package com.sothebys.marketplace.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sothebys.marketplace.entity.BillingAddress;
import com.sothebys.marketplace.entity.PurchaseData;
import com.sothebys.marketplace.entity.ShippingAddress;
import com.sothebys.marketplace.entity.addItemToBag.JsonAddItemToBag;
import com.sothebys.marketplace.entity.bagBillingAddress.JsonBillingAddress;
import com.sothebys.marketplace.entity.defaultBag.JsonDefaultBag;
import com.sothebys.marketplace.entity.getUserShippingAndBillingInfo.JsonUserShippingAndBillingInfo;
import com.sothebys.marketplace.entity.itemsForReview.*;
import com.sothebys.marketplace.entity.purchase.*;
import com.sothebys.marketplace.entity.purchase.Items;
import com.sothebys.marketplace.entity.purchase.Pricing;
import com.sothebys.marketplace.entity.removeItemFromBag.JsonRemoveItemFromBag;
import com.sothebys.marketplace.entity.setShippingRate.JsonSetShippingRate;
import com.sothebys.marketplace.entity.shippingAddress.JsonShippingAddress;
import com.sothebys.marketplace.entity.shippingrate.JsonShippingRate;
import com.sothebys.marketplace.entity.userShippingInfo.JsonUserShippingInfo;
import lombok.extern.slf4j.Slf4j;
import org.mountcloud.graphql.GraphqlClient;
import org.mountcloud.graphql.request.mutation.DefaultGraphqlMutation;
import org.mountcloud.graphql.request.mutation.GraphqlMutation;
import org.mountcloud.graphql.request.query.DefaultGraphqlQuery;
import org.mountcloud.graphql.request.query.GraphqlQuery;
import org.mountcloud.graphql.request.result.ResultAttributtes;
import org.mountcloud.graphql.response.GraphqlResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@Slf4j
public class PurchaseController {

    static ObjectMapper objectMapper = new ObjectMapper();

    final static String graphqlUrl = "https://test-proxy.sothebys.cn/graphql";

    @GetMapping(value = "/defaultBag")
    public ResponseEntity<String> getDefaultBag(@RequestHeader("authorization") String token) throws IOException {

        GraphqlClient client = GraphqlClient.buildGraphqlClient(graphqlUrl);
        Map<String, String> httpHeaders = new HashMap<>();
        httpHeaders.put("authorization", token);
        client.setHttpHeaders(httpHeaders);

        GraphqlQuery query = new DefaultGraphqlQuery("bags");

        ResultAttributtes itemsAttris = new ResultAttributtes("items");
        itemsAttris.addResultAttributes("retailItemId");
        itemsAttris.addResultAttributes("quantity");

        ResultAttributtes bagAttrs = new ResultAttributtes("defaultBag");
        bagAttrs.addResultAttributes("id");
        bagAttrs.addResultAttributes(itemsAttris);

        query.addResultAttributes(bagAttrs);
        GraphqlResponse response = client.doQuery(query);

        Map result = response.getData();
        String json = objectMapper.writeValueAsString(result);
        JsonDefaultBag jsonDefaultBag = objectMapper.readValue(json, JsonDefaultBag.class);


        String bagId = jsonDefaultBag.getData().getBags().getDefaultBag().getId();

        log.info("---------Response bag id: " + new String(Base64.getDecoder().decode(bagId)));

        return ResponseEntity.ok(new String(Base64.getDecoder().decode(bagId)));
    }

    @PostMapping(value = "/retailItemToBag")
    public ResponseEntity<JsonAddItemToBag> addRetailItemToBag(@RequestHeader("authorization") String token,
                                                               @RequestParam("bagId") String bagId,
                                                               @RequestParam("itemId") String itemId) throws IOException {

        GraphqlClient client = GraphqlClient.buildGraphqlClient(graphqlUrl);
        Map<String, String> httpHeaders = new HashMap<>();
        httpHeaders.put("authorization", token);
        client.setHttpHeaders(httpHeaders);

        GraphqlMutation mutation = new DefaultGraphqlMutation("addRetailItemToBag");
        mutation.getRequestParameter().addParameter("bagId", bagId).addParameter("retailItemId", itemId).addParameter("quantity", 1);
        mutation.addResultAttributes("bagId");

        ResultAttributtes retailItem = new ResultAttributtes("retailItem");
        retailItem.addResultAttributes("id");
        retailItem.addResultAttributes("itemInLoggedInCart");

        ResultAttributtes itemsAttr = new ResultAttributtes("items");
        itemsAttr.addResultAttributes("retailItemId");
        itemsAttr.addResultAttributes("quantity");
        itemsAttr.addResultAttributes(retailItem);
        mutation.addResultAttributes(itemsAttr);

        GraphqlResponse mutationResponse = client.doMutation(mutation);
        Map mutationResult = mutationResponse.getData();

        String json = objectMapper.writeValueAsString(mutationResult);
        JsonAddItemToBag jsonAddItemToBag = objectMapper.readValue(json, JsonAddItemToBag.class);

        log.info("---------Response bag id: " + jsonAddItemToBag.getData().getAddRetailItemToBag().getBagId());

        return ResponseEntity.ok(jsonAddItemToBag);
    }

    @GetMapping(value = "/userShippingInfo")
    public ResponseEntity<JsonUserShippingInfo> getUserShippingInfo(@RequestHeader("authorization") String token,
                                                                    @RequestParam("bagId") String bagId) throws UnirestException {

        HttpResponse<String> response = Unirest.post(graphqlUrl)
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"query getUserShippingInfo($id: ID!) {  bagById(id: $id) {    id    bagId    itemCount    bagItemsType    shippingChecks {      id      incompatibleShippingDestinations      invalidShippingAddressCountry      __typename    }    pricing {      id      currency      tax      shippingCost      offerPrice      __typename    }    items {      id      quantity      alert {        id        priceChange {          id          newPrice          oldPrice          __typename        }        unavailable        __typename      }      retailItem {        id        retailItemId        title        creators {          id          displayName          __typename        }        isOwned        objects {          id          objectTypeName          metadata {            key            value {              ... on ObjectMetadataStringValue {                stringValue                __typename              }              ... on ObjectMetadataStringValues {                stringValues                __typename              }              ... on ObjectMetadataFloatValue {                floatValue                __typename              }              ... on ObjectMetadataIntegerValue {                integerValue                __typename              }              ... on ObjectMetadataBooleanValue {                boolValue                __typename              }              __typename            }            __typename          }          __typename        }        pricing {          id          listPrice          __typename        }        media {          images {            title            renditions {              url              imageSize              __typename            }            __typename          }          __typename        }        shipping {          id          offeredServiceTypes          originAddress {            id            city            state            countryISO {              id              alphaTwo              englishShortNameReadingOrder              __typename            }            __typename          }          shipsInternationally          availableShippingDestinations {            id            alphaTwo            englishShortNameReadingOrder            __typename          }          __typename        }        slug        department {          id          title          __typename        }        category {          id          name          slug          __typename        }        __typename      }      variant {        id        groupName        value        __typename      }      __typename    }    shippingAddress {      id      firstName      lastName      company      telephone      street1      street2      city      state      postalCode      floor      countryISO {        id        englishShortNameReadingOrder        alphaTwo        __typename      }      __typename    }    __typename  }}\",\"variables\":{\"id\":\"" + bagId + "\"}}")
                .asString();
        String body = response.getBody();
        JsonUserShippingInfo userShippingInfo = JSONObject.parseObject(body, JsonUserShippingInfo.class);

        log.info("---------Response data: " + userShippingInfo.toString());

        return ResponseEntity.ok(userShippingInfo);
    }

    @PostMapping(value = "/setShippingAddress")
    public ResponseEntity<JsonShippingAddress> setShippingAddress(@RequestHeader("authorization") String token,
                                                                  @RequestBody ShippingAddress shippingAddress,
                                                                  @RequestParam("bagId") String bagId) throws IOException {
        GraphqlClient client = GraphqlClient.buildGraphqlClient(graphqlUrl);
        Map<String, String> httpHeaders = new HashMap<>();
        httpHeaders.put("authorization", token);
        client.setHttpHeaders(httpHeaders);

        GraphqlMutation mutation = new DefaultGraphqlMutation("setBagShippingAddress");

        mutation.getRequestParameter().addParameter("bagId", bagId).addObjectParameter("shippingAddress", shippingAddress);

        mutation.addResultAttributes("id");
        mutation.addResultAttributes("__typename");

        ResultAttributtes shippingChecks = new ResultAttributtes("shippingChecks");
        shippingChecks.addResultAttributes("incompatibleShippingDestinations");
        shippingChecks.addResultAttributes("invalidShippingAddressCountry");
        shippingChecks.addResultAttributes("__typename");

        ResultAttributtes countryISO = new ResultAttributtes("countryISO");
        countryISO.addResultAttributes("id");
        countryISO.addResultAttributes("englishShortNameReadingOrder");
        countryISO.addResultAttributes("alphaTwo");
        countryISO.addResultAttributes("__typename");

        ResultAttributtes shippingAddre = new ResultAttributtes("shippingAddress");
        shippingAddre.addResultAttributes("id");
        shippingAddre.addResultAttributes("firstName");
        shippingAddre.addResultAttributes("lastName");
        shippingAddre.addResultAttributes("telephone");
        shippingAddre.addResultAttributes("company");
        shippingAddre.addResultAttributes("street1");
        shippingAddre.addResultAttributes("street2");
        shippingAddre.addResultAttributes("city");
        shippingAddre.addResultAttributes("state");
        shippingAddre.addResultAttributes("postalCode");
        shippingAddre.addResultAttributes("floor");
        shippingAddre.addResultAttributes("__typename");
        shippingAddre.addResultAttributes(countryISO);

        mutation.addResultAttributes(shippingAddre);
        mutation.addResultAttributes(shippingChecks);

        GraphqlResponse mutationResponse = client.doMutation(mutation);
        Map mutationResult = mutationResponse.getData();

        String json = objectMapper.writeValueAsString(mutationResult);
        JsonShippingAddress jsonShippingAddress = objectMapper.readValue(json, JsonShippingAddress.class);
        log.info("---------Response bag id: " + jsonShippingAddress.getData());
        return ResponseEntity.ok(jsonShippingAddress);
    }

    @GetMapping(value = "/shippingRate")
    public ResponseEntity<Map<String, List<String>>> getShippingRate(@RequestHeader("authorization") String token,
                                                                     @RequestParam("bagId") String bagId) throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.post(graphqlUrl)
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"query getBagInfoWithShippingRate($id: ID!) {  bagById(id: $id) {    id    bagId    bagItemsType    itemCount    pricing {      id      currency      tax      shippingCost      offerPrice      __typename    }    availableItemsShippingRates {      items {        id        alert {          id          unavailable          priceChange {            id            oldPrice            newPrice            __typename          }          __typename        }        availableShippingRates {          id          deduplicationId          approxDelivery          description          price          rateId          serviceLevel          information          __typename        }        quantity        retailItem {          id          retailItemId          sku          title          description          slug          isOwned          creators {            displayName            __typename          }          pricing {            id            currency            listPrice            __typename          }          category {            id            name            slug            __typename          }          media(imageSizes: Small) {            images {              title              renditions {                url                imageSize                __typename              }              __typename            }            __typename          }          config {            finalSale            __typename          }          department {            title            __typename          }          objects {            id            objectTypeName            metadata {              key              value {                ... on ObjectMetadataStringValue {                  stringValue                  __typename                }                ... on ObjectMetadataStringValues {                  stringValues                  __typename                }                ... on ObjectMetadataFloatValue {                  floatValue                  __typename                }                ... on ObjectMetadataBooleanValue {                  boolValue                  __typename                }                ... on ObjectMetadataIntegerValue {                  integerValue                  __typename                }                __typename              }              __typename            }            __typename          }          shipping {            id            shipsInternationally            offeredServiceTypes            originAddress {              city              state              countryISO {                alphaTwo                englishShortNameReadingOrder                __typename              }              __typename            }            __typename          }          __typename        }        variant {          id          variantId          groupName          value          __typename        }        __typename      }      selectedRate {        id        rateId        deduplicationId        pickupDate        __typename      }      shippingRates {        id        deduplicationId        approxDelivery        description        price        rateId        serviceLevel        information        providerCode        serviceCode        __typename      }      __typename    }    __typename  }}\",\"variables\":{\"id\":\"" + bagId + "\"}}")
                .asString();

        String body = response.getBody();
        JsonShippingRate itemShippingRate = JSONObject.parseObject(body, JsonShippingRate.class);

        log.info("---------Response data: " + itemShippingRate.toString());

        Map<String, List<String>> map = new HashMap<>();

        itemShippingRate.getData().getBagById().getAvailableItemsShippingRates().forEach(availableItemsShippingRates -> {
            String retailItemId = availableItemsShippingRates.getItems().stream().findFirst().get().getRetailItem().getRetailItemId();
            List<String> list = new ArrayList<>();
            availableItemsShippingRates.getShippingRates().forEach(shippingRates -> list.add(shippingRates.getRateId()));
            map.put(retailItemId, list);
        });

        String json = objectMapper.writeValueAsString(map);
        log.info("get shipping rate map data: " + json);

        return ResponseEntity.ok(map);
    }

    @PostMapping(value = "/shippingRate")
    public ResponseEntity<List<JsonSetShippingRate>> setShippingRate(@RequestHeader("authorization") String token,
                                                                     @RequestBody Map<String, List<String>> shippingRateMap,
                                                                     @RequestParam("bagId") String bagId) throws IOException {
        List<JsonSetShippingRate> list = new ArrayList();

        for (String key : shippingRateMap.keySet()) {
            List<String> value = shippingRateMap.get(key);
            log.info("Key = " + key);
            log.info("value = " + value.get(0));

            try {
                HttpResponse<String> response = Unirest.post(graphqlUrl)
                        .header("Authorization", token)
                        .header("Content-Type", "application/json")
                        .body("{\"query\":\"mutation setBagItemsShippingRate($bagId: String!, $retailItemIds: [String!]!, $shippingRateId: String!, $pickupDate: String) {  setBagItemsShippingRate(    bagId: $bagId    retailItemIds: $retailItemIds    shippingRateId: $shippingRateId    pickupDate: $pickupDate  ) {    id    items {      id      selectedShippingRate {        id        deduplicationId        pickupDate        __typename      }      __typename    }    __typename  }}\",\"variables\":{\"bagId\":\"" + bagId + "\",\"retailItemIds\":[\"" + key + "\"],\"shippingRateId\":\"" + value.get(0) + "\"}}")
                        .asString();
                String body = response.getBody();
                JsonSetShippingRate data = JSONObject.parseObject(body, JsonSetShippingRate.class);
                log.info("---------Response data: " + data.toString());

                list.add(data);
            } catch (UnirestException e) {
                throw new RuntimeException(e);
            }

        }

        return ResponseEntity.ok(list);
    }


    @GetMapping(value = "/userShippingAndBillingInfo")
    public ResponseEntity<BillingAddress> getUserShippingAndBillingInfo(@RequestHeader("authorization") String token,
                                                                        @RequestParam("bagId") String bagId,
                                                                        @RequestParam("setBillingAsShippingAddress") boolean setBillingAsShippingAddress) throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.post(graphqlUrl)
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"query getUserShippingAndBillingInfo($id: ID!) {  bagById(id: $id) {    id    bagId    itemCount    pricing {      id      currency      tax      shippingCost      __typename    }    items {      quantity      alert {        id        priceChange {          id          oldPrice          newPrice          __typename        }        unavailable        __typename      }      retailItem {        id        retailItemId        title        slug        isOwned        objects {          id          objectTypeName          metadata {            key            value {              ... on ObjectMetadataStringValue {                stringValue                __typename              }              ... on ObjectMetadataStringValues {                stringValues                __typename              }              ... on ObjectMetadataFloatValue {                floatValue                __typename              }              ... on ObjectMetadataBooleanValue {                boolValue                __typename              }              ... on ObjectMetadataIntegerValue {                integerValue                __typename              }              __typename            }            __typename          }          __typename        }        creators {          displayName          __typename        }        pricing {          id          currency          listPrice          __typename        }        media(imageSizes: Small) {          images {            renditions {              url              imageSize              __typename            }            __typename          }          __typename        }        department {          id          title          __typename        }        category {          id          name          slug          __typename        }        shipping {          shipsInternationally          __typename        }        __typename      }      variant {        id        groupName        value        __typename      }      __typename    }    shippingAddress {      id      firstName      lastName      company      telephone      street1      street2      city      state      postalCode      floor      countryISO {        id        alphaTwo        englishShortNameReadingOrder        __typename      }      __typename    }    billingAddress {      id      city      countryISO {        id        englishShortNameReadingOrder        alphaTwo        __typename      }      postalCode      stateOrProvince      street      __typename    }    __typename  }}\",\"variables\":{\"id\":\"" + bagId + "\"}}")
                .asString();

        String body = response.getBody();
        JsonUserShippingAndBillingInfo data = JSONObject.parseObject(body, JsonUserShippingAndBillingInfo.class);

        log.info("---------Response data: " + data.toString());

        BillingAddress billingAddress = null;

        if (setBillingAsShippingAddress) {
            billingAddress = new BillingAddress();
            billingAddress.setCountry(data.getData().getBagById().getShippingAddress().getCountryISO().getAlphaTwo());
            billingAddress.setCity(data.getData().getBagById().getShippingAddress().getCity());
            billingAddress.setStreet(data.getData().getBagById().getShippingAddress().getStreet1() + " " + data.getData().getBagById().getShippingAddress().getStreet2() + " " + data.getData().getBagById().getShippingAddress().getFloor());
            billingAddress.setStateOrProvince(data.getData().getBagById().getShippingAddress().getState());
            billingAddress.setPostalCode(data.getData().getBagById().getShippingAddress().getPostalCode());
        }

        return ResponseEntity.ok(billingAddress);
    }


    @PostMapping(value = "/billingAddress")
    public ResponseEntity<JsonBillingAddress> setBillingAddress(@RequestHeader("authorization") String token,
                                                                @RequestBody BillingAddress billingAddress,
                                                                @RequestParam("bagId") String bagId) throws IOException {
        GraphqlClient client = GraphqlClient.buildGraphqlClient(graphqlUrl);
        Map<String, String> httpHeaders = new HashMap<>();
        httpHeaders.put("authorization", token);
        client.setHttpHeaders(httpHeaders);

        GraphqlMutation mutation = new DefaultGraphqlMutation("setBagBillingAddress");

        mutation.getRequestParameter().addParameter("bagId", bagId).addObjectParameter("billingAddress", billingAddress);

        mutation.addResultAttributes("id");
        mutation.addResultAttributes("__typename");

        ResultAttributtes resultAttributtes = new ResultAttributtes("billingAddress");
        resultAttributtes.addResultAttributes("id");
        resultAttributtes.addResultAttributes("street");
        resultAttributtes.addResultAttributes("city");
        resultAttributtes.addResultAttributes("stateOrProvince");
        resultAttributtes.addResultAttributes("postalCode");

        mutation.addResultAttributes(resultAttributtes);

        GraphqlResponse mutationResponse = client.doMutation(mutation);
        Map mutationResult = mutationResponse.getData();

        String json = objectMapper.writeValueAsString(mutationResult);
        JsonBillingAddress jsonBillingAddress = objectMapper.readValue(json, JsonBillingAddress.class);
        log.info("---------Response bag id: " + jsonBillingAddress.getData());
        return ResponseEntity.ok(jsonBillingAddress);
    }

    @GetMapping(value = "/itemsForReview")
    public ResponseEntity<JsonItemsForReview> getItemsForReviewGraphql(@RequestHeader("authorization") String token,
                                                                       @RequestParam("bagId") String bagId) throws UnirestException {

        HttpResponse<String> response = Unirest.post(graphqlUrl)
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"query getItemsForReview($id: ID!) {  bagById(id: $id) {    id    bagId    bagItemsType    comment    pricing {      id      currency      subtotalPrice      totalPrice      tax      shippingCost      offerPrice      __typename    }    availableItemsShippingRates {      items {        id        alert {          id          unavailable          priceChange {            id            oldPrice            newPrice            __typename          }          __typename        }        availableShippingRates {          id          deduplicationId          approxDelivery          description          price          rateId          serviceLevel          information          __typename        }        quantity        retailItem {          id          retailItemId          sku          title          description          creators {            displayName            __typename          }          pricing {            id            currency            listPrice            __typename          }          media(imageSizes: Small) {            images {              title              renditions {                url                imageSize                __typename              }              __typename            }            __typename          }          config {            finalSale            __typename          }          shipping {            id            shipsInternationally            offeredServiceTypes            originAddress {              city              state              countryISO {                alphaTwo                englishShortNameReadingOrder                __typename              }              __typename            }            __typename          }          __typename        }        variant {          id          variantId          groupName          value          __typename        }        __typename      }      selectedRate {        id        rateId        deduplicationId        serviceLevel        approxDelivery        price        description        __typename      }      shippingRates {        id        deduplicationId        approxDelivery        description        price        rateId        serviceLevel        information        providerCode        serviceCode        __typename      }      __typename    }    items {      id      alert {        id        priceChange {          id          oldPrice          newPrice          __typename        }        unavailable        __typename      }      variant {        id        variantId        groupName        value        __typename      }      retailItem {        id        isOwned        retailItemId        sku        title        description        department {          id          title          __typename        }        creators {          displayName          __typename        }        objects {          id          objectTypeName          metadata {            key            value {              ... on ObjectMetadataStringValue {                stringValue                __typename              }              ... on ObjectMetadataStringValues {                stringValues                __typename              }              ... on ObjectMetadataFloatValue {                floatValue                __typename              }              ... on ObjectMetadataBooleanValue {                boolValue                __typename              }              ... on ObjectMetadataIntegerValue {                integerValue                __typename              }              __typename            }            __typename          }          __typename        }        pricing {          id          currency          listPrice          __typename        }        media(imageSizes: Small) {          images {            title            renditions {              url              imageSize              __typename            }            __typename          }          __typename        }        slug        config {          finalSale          __typename        }        department {          id          title          __typename        }        category {          id          name          slug          __typename        }        shipping {          offeredServiceTypes          originAddress {            city            state            countryISO {              alphaTwo              englishShortNameReadingOrder              __typename            }            __typename          }          __typename        }        shipping {          shipsInternationally          __typename        }        __typename      }      quantity      variant {        id        groupName        value        __typename      }      __typename    }    shippingAddress {      id      firstName      lastName      telephone      company      street1      street2      floor      countryISO {        id        alphaTwo        englishShortNameReadingOrder        __typename      }      city      state      postalCode      __typename    }    billingAddress {      street      city      stateOrProvince      postalCode      countryISO {        id        englishShortNameReadingOrder        alphaTwo        __typename      }      __typename    }    __typename  }}\",\"variables\":{\"id\":\"" + bagId + "\"}}")
                .asString();

        String body = response.getBody();
        JsonItemsForReview data = JSONObject.parseObject(body, JsonItemsForReview.class);

        log.info("---------Response data: " + data.toString());

        return ResponseEntity.ok(data);
    }


    @PostMapping(value = "/convert")
    public ResponseEntity<JsonPurchase> convertPurchaseOrder(@RequestHeader("authorization") String token,
                                                             @RequestBody PurchaseData purchaseData) {
        JsonPurchase jsonPurchase = new JsonPurchase();

        jsonPurchase.setId(purchaseData.getId());
        jsonPurchase.setCredit_card(purchaseData.getCredit_card());
        jsonPurchase.setCustomer(purchaseData.getCustomer());
        jsonPurchase.setPurchase_date(purchaseData.getPurchase_date());
        jsonPurchase.setPurchase_number(purchaseData.getPurchase_number());
        jsonPurchase.setPurchase_number_display(purchaseData.getPurchase_number_display());
        jsonPurchase.setCart_id(purchaseData.getCart_id());

        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setCity(purchaseData.getJsonItemsForReview().getData().getBagById().getBillingAddress().getCity());
        billingAddress.setCountry(purchaseData.getJsonItemsForReview().getData().getBagById().getBillingAddress().getCountryISO().getAlphaTwo());
        billingAddress.setPostalCode(purchaseData.getJsonItemsForReview().getData().getBagById().getBillingAddress().getPostalCode());
        billingAddress.setStreet(purchaseData.getJsonItemsForReview().getData().getBagById().getBillingAddress().getStreet());
        billingAddress.setStateOrProvince(purchaseData.getJsonItemsForReview().getData().getBagById().getBillingAddress().getStateOrProvince());
        jsonPurchase.setBilling_address(billingAddress);

        Shipping_address shipping_address = new Shipping_address();
        shipping_address.setCountry(purchaseData.getJsonItemsForReview().getData().getBagById().getShippingAddress().getCountryISO().getAlphaTwo());
        shipping_address.setCity(purchaseData.getJsonItemsForReview().getData().getBagById().getShippingAddress().getCity());
        shipping_address.setFirst_name(purchaseData.getJsonItemsForReview().getData().getBagById().getShippingAddress().getFirstName());
        shipping_address.setLast_name(purchaseData.getJsonItemsForReview().getData().getBagById().getShippingAddress().getLastName());
        shipping_address.setState(purchaseData.getJsonItemsForReview().getData().getBagById().getShippingAddress().getState());
        shipping_address.setPostal_code(purchaseData.getJsonItemsForReview().getData().getBagById().getShippingAddress().getPostalCode());
        shipping_address.setTelephone(purchaseData.getJsonItemsForReview().getData().getBagById().getShippingAddress().getTelephone());
        shipping_address.setStreet1(purchaseData.getJsonItemsForReview().getData().getBagById().getShippingAddress().getStreet1());
        jsonPurchase.setShipping_address(shipping_address);

        Pricing pricing = new Pricing();
        pricing.setCurrency(purchaseData.getJsonItemsForReview().getData().getBagById().getPricing().getCurrency());
        pricing.setShipping(purchaseData.getJsonItemsForReview().getData().getBagById().getPricing().getShippingCost());
        pricing.setSubtotal(purchaseData.getJsonItemsForReview().getData().getBagById().getPricing().getSubtotalPrice());
        pricing.setTax(purchaseData.getJsonItemsForReview().getData().getBagById().getPricing().getTax());
        pricing.setTotal(purchaseData.getJsonItemsForReview().getData().getBagById().getPricing().getTotalPrice());
        jsonPurchase.setPricing(pricing);

        List<Items> listItems = new ArrayList<>();

        List<AvailableItemsShippingRates> availableItemsShippingRates = purchaseData.getJsonItemsForReview().getData().getBagById().getAvailableItemsShippingRates();

        availableItemsShippingRates.forEach(aisr -> {
            Items itemsPurchase = new Items();
            Retail_item retail_item = new Retail_item();
            Shipping_rate shipping_rate = new Shipping_rate();

            RetailItem retailItem = aisr.getItems().get(0).getRetailItem();

            com.sothebys.marketplace.entity.itemsForReview.Items items1 = purchaseData.getJsonItemsForReview().getData().getBagById().getItems().stream().filter(items -> items.getRetailItem().getRetailItemId().equals(retailItem.getRetailItemId())).findFirst().get();

            String shippingService = items1.getRetailItem().getShipping().getOfferedServiceTypes().get(0);
            Long object_id = Long.valueOf(new String(Base64.getDecoder().decode(items1.getRetailItem().getObjects().get(0).getId())).substring(7));

            retail_item.setId(retailItem.getRetailItemId());
            retail_item.setTitle(retailItem.getTitle());
            retail_item.setDescription(retailItem.getDescription());
            retail_item.setSku(retailItem.getSku());
            retail_item.setFinal_sale(retailItem.getConfig().isFinalSale());
            retail_item.setList_price(retailItem.getPricing().getListPrice());
            retail_item.set_owned(retailItem.isOwned());
            retail_item.setObject_ids(object_id);
            retail_item.setSales_entity("INC");
            itemsPurchase.setRetail_item(retail_item);

            SelectedRate selectedRate = aisr.getSelectedRate();
            ShippingRates shippingRates = aisr.getShippingRates().get(0);

            shipping_rate.setId(selectedRate.getRateId());
            shipping_rate.setPrice(selectedRate.getPrice());
            shipping_rate.setCarrier_service_level(selectedRate.getServiceLevel());
            shipping_rate.setCarrier_approx_delivery(selectedRate.getApproxDelivery());
            shipping_rate.setCarrier_description(selectedRate.getDescription());
            shipping_rate.setDeduplication_id(selectedRate.getDeduplicationId());
            shipping_rate.setShipping_service(shippingService);
            shipping_rate.setService_code(shippingRates.getServiceCode());
            shipping_rate.setProvider_code(shippingRates.getProviderCode());
            shipping_rate.set_estimate(false);
            shipping_rate.set_hand_picked(false);
            itemsPurchase.setShipping_rate(shipping_rate);


            itemsPurchase.setQuantity(1);
            itemsPurchase.setSubtotal_price(retailItem.getPricing().getListPrice());
            itemsPurchase.setPrice(retailItem.getPricing().getListPrice());

            listItems.add(itemsPurchase);
        });

        jsonPurchase.setItems(listItems);

        log.info(jsonPurchase.toString());
        return ResponseEntity.ok(jsonPurchase);
    }

    @PostMapping(value = "/purchase")
    public ResponseEntity<JsonPurchase> purchaseOrder(@RequestHeader("authorization") String token,
                                                      @RequestBody JsonPurchase jsonPurchase) {
        log.info(jsonPurchase.toString());

        return ResponseEntity.ok(jsonPurchase);
    }


    @PostMapping(value = "/removeItem")
    public ResponseEntity<JsonRemoveItemFromBag> removeItemFromBag(@RequestHeader("authorization") String token,
                                                                   @RequestParam("itemId") String itemId,
                                                                   @RequestParam("bagId") String bagId) throws UnirestException {

        HttpResponse<String> response = Unirest.post("https://test-proxy.sothebys.cn/graphql")
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"mutation removeRetailItemFromBagByBagId($retailItemId: String!, $bagId: String!) {  removeRetailItemFromBagByBagId(retailItemId: $retailItemId, bagId: $bagId) {    id    bagId    shippingChecks {      id      incompatibleShippingDestinations      invalidShippingAddressCountry      __typename    }    items {      id      itemId      __typename    }    __typename  }}\",\"variables\":{\"retailItemId\":\"" + itemId + "\",\"bagId\":\"" + bagId + "\"}}")
                .asString();

        String body = response.getBody();
        JsonRemoveItemFromBag data = JSONObject.parseObject(body, JsonRemoveItemFromBag.class);

        log.info("---------Response items size: " + data.getData().getRemoveRetailItemFromBagByBagId().getItems().size());

        return ResponseEntity.ok(data);
    }

}
