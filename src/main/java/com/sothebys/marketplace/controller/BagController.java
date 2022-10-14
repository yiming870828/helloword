package com.sothebys.marketplace.controller;//package org.example.com.sothebys.marketplace.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sothebys.marketplace.entity.bag.JsonBag;
import lombok.extern.slf4j.Slf4j;
import com.sothebys.marketplace.entity.BillingAddress;
import com.sothebys.marketplace.entity.ShippingAddress;
import com.sothebys.marketplace.entity.addItemToBag.JsonAddItemToBag;
import com.sothebys.marketplace.entity.bagBillingAddress.JsonBillingAddress;
import com.sothebys.marketplace.entity.defaultBag.JsonDefaultBag;
import com.sothebys.marketplace.entity.getUserShippingAndBillingInfo.JsonUserShippingAndBillingInfo;
import com.sothebys.marketplace.entity.itemsForReview.JsonItemsForReview;
import com.sothebys.marketplace.entity.purchase.JsonPurchase;
import com.sothebys.marketplace.entity.setShippingRate.JsonSetShippingRate;
import com.sothebys.marketplace.entity.shippingAddress.JsonShippingAddress;
import com.sothebys.marketplace.entity.shippingrate.JsonShippingRate;
import org.mountcloud.graphql.GraphqlClient;
import org.mountcloud.graphql.request.mutation.DefaultGraphqlMutation;
import org.mountcloud.graphql.request.mutation.GraphqlMutation;
import org.mountcloud.graphql.request.query.DefaultGraphqlQuery;
import org.mountcloud.graphql.request.query.GraphqlQuery;
import org.mountcloud.graphql.request.result.ResultAttributtes;
import org.mountcloud.graphql.response.GraphqlResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

@RestController
@Slf4j
public class BagController {

    static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException, UnirestException {
        String itemId = "8ff15d52-997c-4093-9bed-75eec29e088e";

//        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik16TXdPVVk1UTBRME9EQTFOekV4T0RFMFFUZEZORFUwUmpsQk5EbENSVVV3TlVRNFJrWTRPUSJ9.eyJodHRwOi8vc2NoZW1hcy5zb3RoZWJ5cy1zdGFnaW5nLmNvbS9hcHBfbWV0YWRhdGEiOnsiYSI6MCwiY29uc2VudCI6eyJjb25zZW50T25TaWdudXAiOnRydWUsImxhdGVzdENvbnNlbnQiOiIyMDIwLTAxLTEzVDE4OjUzOjQwKzAwOjAwIn0sImN1c3RvbWVyRGF0YSI6eyJjbGllbnRJbmZvSWQiOiJiMzlmN2ZkOC1kY2EwLTI0M2ItZTA1My0wMTAwMDA3Zjc1M2YiLCJwYXJ0eUlkIjo4NzY3NjQ3NDMsInByZWZlcnJlZCI6ZmFsc2V9LCJ3ZWJVc2VySWQiOjQyOTU5NTF9LCJodHRwOi8vc2NoZW1hcy5zb3RoZWJ5cy1zdGFnaW5nLmNvbS91c2VyTWV0YWRhdGEiOnsiZmlyc3ROYW1lIjoiU3RhZ2UiLCJsYXN0TmFtZSI6IlRlc3RlciIsIm5hbWUiOiJTdGFnZSBUZXN0ZXIiLCJuZXdVc2VyIjpmYWxzZSwibm9FbWFpbHMiOmZhbHNlLCJvcHRlZE91dCI6dHJ1ZSwidGl0bGUiOiJNciJ9LCJpc3MiOiJodHRwczovL2FjY291bnRzLnN0YWdpbmcuc290aGVsYWJzLmNvbS8iLCJzdWIiOiJhdXRoMHw1ZTFjYmNiNGU3Y2MwMjBmMTU5ZDE5ZGMiLCJhdWQiOlsiaHR0cHM6Ly9jdXN0b21lci5hcGkuc3RnLnNvdGhlYnlzLmNvbSIsImh0dHBzOi8vc290aGVieXMtc3RnLmF1dGgwLmNvbS91c2VyaW5mbyJdLCJpYXQiOjE2NjIwMjMwOTQsImV4cCI6MTY2MjEwOTQ5NCwiYXpwIjoicGJMTmVrclh1R1d1eUNFZjN6eDlxUDJzUEFLVm9BYTQiLCJzY29wZSI6Im9wZW5pZCBlbWFpbCJ9.br6Rn4HiRePdpWNwgIyQ7Tv7Gs3UjQ7zgTo7H6_9u10FCi3yjDRv4_SaOPgmMFoVfivBPt8yb_0Lx-0N--DRkOFmBhed7s7Tk92UbiS9b-z9fdZNCr2UqvsN_mbWSBJeZo6ScbnhO_2-JckVC6ouW4nru7OB9v3BAuRCk3j5AG2wJnGses48LMhAMbuG06o19WJAFZasgNjtiu1hA5nAAUuasL68gtPI_P7VbeJVb14-Tzh-Ug4HCYgszEPyIk41AZYUGs2KIkVJur1L2OZo4FeuEfk8euPKz2505mSMyPJTCzelQt43-Zp0ZQDQG0V16SrFBFOygjjGsH5XmITYOg";
//        addRetailItemToBag(token, itemId);

        String bearerToken = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik16TXdPVVk1UTBRME9EQTFOekV4T0RFMFFUZEZORFUwUmpsQk5EbENSVVV3TlVRNFJrWTRPUSJ9.eyJodHRwOi8vc2NoZW1hcy5zb3RoZWJ5cy1zdGFnaW5nLmNvbS9hcHBfbWV0YWRhdGEiOnsiYSI6MCwiY29uc2VudCI6eyJjb25zZW50T25TaWdudXAiOnRydWUsImxhdGVzdENvbnNlbnQiOiIyMDIwLTAxLTEzVDE4OjU1OjQyKzAwOjAwIn0sImN1c3RvbWVyRGF0YSI6eyJjbGllbnRJbmZvSWQiOiJiMzlmN2ZkOC1kYzBjLTI0M2ItZTA1My0wMTAwMDA3Zjc1M2YiLCJwYXJ0eUlkIjo4NzY3NjQ2OTIsInByZWZlcnJlZCI6ZmFsc2V9LCJ3ZWJVc2VySWQiOjQyOTU5NTJ9LCJodHRwOi8vc2NoZW1hcy5zb3RoZWJ5cy1zdGFnaW5nLmNvbS91c2VyTWV0YWRhdGEiOnsiZW1haWwiOiJzdGctdmVyMkBzb3RoZWJ5c3FhLmNvbSIsImVtYWlsX2EiOiJzdGctdmVyMkBzb3RoZWJ5c3FhLmNvbSIsImZpcnN0TmFtZSI6IlN0YWN5IiwibGFzdE5hbWUiOiJUZXN0ZXJvbmkiLCJuYW1lIjoiU3RhY3kgVGVzdGVyb25pIiwibmV3VXNlciI6ZmFsc2UsIm5vRW1haWxzIjpmYWxzZSwib3B0ZWRPdXQiOmZhbHNlLCJwcmVmZXJlbmNlcyI6eyJmb250U2l6ZSI6MTJ9LCJ0ZXN0RGF0YSI6InN0Zy12ZXIyQHNvdGhlYnlzcWEuY29tIiwidGl0bGUiOiJNcyJ9LCJpc3MiOiJodHRwczovL2FjY291bnRzLnN0YWdpbmcuc290aGVsYWJzLmNvbS8iLCJzdWIiOiJhdXRoMHw1ZTFjYmQyZTk3YzM2MzBlODQ3NTY1YzIiLCJhdWQiOlsiaHR0cHM6Ly9jdXN0b21lci5hcGkuc3RnLnNvdGhlYnlzLmNvbSIsImh0dHBzOi8vc290aGVieXMtc3RnLmF1dGgwLmNvbS91c2VyaW5mbyJdLCJpYXQiOjE2NjIxMTU2MTksImV4cCI6MTY2MjIwMjAxOSwiYXpwIjoiQ0p0b29mMXNqaW55WlVZRE1TM21ZNFh2SEhCZ0lxbkIiLCJzY29wZSI6Im9wZW5pZCBlbWFpbCJ9.gs90xyWpsNg3mj7mqrs-5KBFks3Wtb9BGaBfLVT_404g12tTLgYrlJF21-lmSfjjkIDliIUli7a8fRV4tPe1VIEeig7xwS5HlwlbkkpztgvOeEpK_mgiORL5jtVdeTX0RW7yzr44CRrpnwXfe7MX6EcTWqJTCS4hdOu5r2j58BKKShWBNjDo8Zt-v6WQV9MfOTdZ4AtfJGzDZy1vODLOhobyoXKEaZwBX9D9dmxVzEAaA-9p0Kx7QmOIiA2PQpeX1r_p704bwoS1WCNAYYhe5W79pbiJTqssDewDmsoVP64r1mEDa6SxdV7gPFe9DcaWWkPfrpLAm1EDTOfMhzZYug";

        //get all items from default bag
        JsonDefaultBag jsonDefaultBag = testBagQueryGraphql(bearerToken);
        boolean flag = jsonDefaultBag.getData().getBags().getDefaultBag().getItems().stream().anyMatch(items -> items.getRetailItemId().equals(itemId));

        String bagId = jsonDefaultBag.getData().getBags().getDefaultBag().getId();

        if (bagId != null) {
            bagId = new String(Base64.getDecoder().decode(bagId));
            bagId = bagId.substring(4);
        }

        log.info("get bag id: " + bagId);

        //if items not exist, add to bags
        if (!flag) {
            JsonAddItemToBag jsonAddItemToBag = testAddRetailItemToBagMutationGraphql(bagId, itemId, bearerToken);
        }

        //getUserShippingInfo and setShippingAddress
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setCountry("GB");
        shippingAddress.setFirstName("yiming");
        shippingAddress.setLastName("xie");
        shippingAddress.setTelephone("12345577");
        shippingAddress.setStreet1("87 Melwood Dr");
        shippingAddress.setCity("Liverpool");
        shippingAddress.setState("Liverpool");
        shippingAddress.setPostalCode("L12 8RN");
        shippingAddress.setFloor("2");

        JsonShippingAddress jsonShippingAddress = testSetBagShippingAddressGraphql(bagId, shippingAddress, bearerToken);

        //getBagInfoWithShippingRate
        JsonShippingRate itemShippingRate = getItemShippingRate(bearerToken, bagId);

        //setBagInfoWithShippingRate
        List<JsonSetShippingRate> rateIdList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        itemShippingRate.getData().getBagById().getAvailableItemsShippingRates().forEach(availableItemsShippingRates -> {
            String retailItemId = availableItemsShippingRates.getItems().stream().findFirst().get().getRetailItem().getRetailItemId();
            List<String> list = new ArrayList<>();
            availableItemsShippingRates.getShippingRates().forEach(shippingRates -> list.add(shippingRates.getRateId()));
            map.put(retailItemId, list);
        });

        String json = objectMapper.writeValueAsString(map);
        log.info("get shipping rate map data: " + json);


        map.forEach((key, value) -> {
            try {
                JsonSetShippingRate shippingRate = testSetShippingRate(bearerToken, key, itemId, value.get(0));
                rateIdList.add(shippingRate);
            } catch (UnirestException e) {
                throw new RuntimeException(e);
            }
            System.out.println(key + ":" + value);
        });

        log.info("shipping rate size: " + rateIdList.size());


        //get billing address
        BillingAddress userShippingAndBillingInfoGraphql = getUserShippingAndBillingInfoGraphql(bearerToken, bagId, true);

        if (userShippingAndBillingInfoGraphql == null) {
            userShippingAndBillingInfoGraphql.setCountry("GB");
            userShippingAndBillingInfoGraphql.setCity("London");
            userShippingAndBillingInfoGraphql.setStreet("sgag");
            userShippingAndBillingInfoGraphql.setStateOrProvince("London");
            userShippingAndBillingInfoGraphql.setPostalCode("L12");
        }

        //set billing address
        JsonBillingAddress jsonBillingAddress = testSetBillingAddressGraphql(bagId, userShippingAndBillingInfoGraphql, bearerToken);

        //get Items for Review
        JsonItemsForReview jsonItemsForReview = testGetItemsForReviewGraphql(bearerToken, bagId);

        //place order, call purchase api
        JsonPurchase jsonPurchase = purchaseOrder(jsonItemsForReview);
        log.info(jsonPurchase.toString());
    }

    public static JsonAddItemToBag testAddRetailItemToBagMutationGraphql(String bagId, String itemId, String token) throws IOException {
        GraphqlClient client = GraphqlClient.buildGraphqlClient("https://test-proxy.sothebys.cn/graphql");
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
        return jsonAddItemToBag;
    }

    public static JsonShippingAddress testSetBagShippingAddressGraphql(String bagId, ShippingAddress shippingAddress, String token) throws IOException {
        GraphqlClient client = GraphqlClient.buildGraphqlClient("https://test-proxy.sothebys.cn/graphql");
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
        return jsonShippingAddress;
    }


    public static JsonSetShippingRate testSetShippingRateGraphql(String bagId, List<String> items, String shippingRateId, String token) throws IOException {
        GraphqlClient client = GraphqlClient.buildGraphqlClient("https://test-proxy.sothebys.cn/graphql");
        Map<String, String> httpHeaders = new HashMap<>();
        httpHeaders.put("authorization", token);
        client.setHttpHeaders(httpHeaders);

        GraphqlMutation mutation = new DefaultGraphqlMutation("setBagShippingAddress");

        mutation.getRequestParameter().addParameter("bagId", bagId).addObjectParameter("retailItemIds", items).addParameter("shippingRateId", shippingRateId);

        mutation.addResultAttributes("id");
        mutation.addResultAttributes("__typename");

        mutation.addResultAttributes("items");

        GraphqlResponse mutationResponse = client.doMutation(mutation);
        Map mutationResult = mutationResponse.getData();

        String json = objectMapper.writeValueAsString(mutationResult);
        JsonSetShippingRate shippingRate = objectMapper.readValue(json, JsonSetShippingRate.class);
        log.info("---------Response bag id: " + shippingRate.getData());
        return shippingRate;
    }


    public static JsonSetShippingRate testSetShippingRate(String token, String bagId, String itemId, String shippingRateId) throws UnirestException {
        HttpResponse<String> response = Unirest.post("https://test-proxy.sothebys.cn/graphql")
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"mutation setBagItemsShippingRate($bagId: String!, $retailItemIds: [String!]!, $shippingRateId: String!, $pickupDate: String) {  setBagItemsShippingRate(    bagId: $bagId    retailItemIds: $retailItemIds    shippingRateId: $shippingRateId    pickupDate: $pickupDate  ) {    id    items {      id      selectedShippingRate {        id        deduplicationId        pickupDate        __typename      }      __typename    }    __typename  }}\",\"variables\":{\"bagId\":\"" + bagId + "\",\"retailItemIds\":[\"" + itemId + "\"],\"shippingRateId\":\"" + shippingRateId + "\"}}")
                .asString();

        String body = response.getBody();
        JsonSetShippingRate data = JSONObject.parseObject(body, JsonSetShippingRate.class);

        log.info("---------Response data: " + data.toString());
        return data;
    }

    public static JsonBillingAddress testSetBillingAddressGraphql(String bagId, BillingAddress billingAddress, String token) throws IOException {
        GraphqlClient client = GraphqlClient.buildGraphqlClient("https://test-proxy.sothebys.cn/graphql");
        Map<String, String> httpHeaders = new HashMap<>();
        httpHeaders.put("authorization", token);
        client.setHttpHeaders(httpHeaders);

        GraphqlMutation mutation = new DefaultGraphqlMutation("setBagShippingAddress");

        mutation.getRequestParameter().addParameter("bagId", bagId).addObjectParameter("billingAddress", billingAddress);

        mutation.addResultAttributes("id");
        mutation.addResultAttributes("__typename");

        ResultAttributtes resultAttributtes = new ResultAttributtes("billingAddress");
        resultAttributtes.addResultAttributes("id");
        resultAttributtes.addResultAttributes("street");
        resultAttributtes.addResultAttributes("city");

        mutation.addResultAttributes(resultAttributtes);

        GraphqlResponse mutationResponse = client.doMutation(mutation);
        Map mutationResult = mutationResponse.getData();

        String json = objectMapper.writeValueAsString(mutationResult);
        JsonBillingAddress jsonBillingAddress = objectMapper.readValue(json, JsonBillingAddress.class);
        log.info("---------Response bag id: " + jsonBillingAddress.getData());
        return jsonBillingAddress;
    }


    public static JsonDefaultBag testBagQueryGraphql(String token) throws IOException {
        GraphqlClient client = GraphqlClient.buildGraphqlClient("https://test-proxy.sothebys.cn/graphql");
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
        JsonDefaultBag jsonAddItemToBag = objectMapper.readValue(json, JsonDefaultBag.class);

        log.info("---------Response bag id: " + jsonAddItemToBag.getData());
        return jsonAddItemToBag;
    }


    public static JsonShippingRate getItemShippingRate(String token, String bagId) throws UnirestException {

        HttpResponse<String> response = Unirest.post("https://test-proxy.sothebys.cn/graphql")
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"query getBagInfoWithShippingRate($id: ID!) {  bagById(id: $id) {    id    bagId    bagItemsType    itemCount    pricing {      id      currency      tax      shippingCost      offerPrice      __typename    }    availableItemsShippingRates {      items {        id        alert {          id          unavailable          priceChange {            id            oldPrice            newPrice            __typename          }          __typename        }        availableShippingRates {          id          deduplicationId          approxDelivery          description          price          rateId          serviceLevel          information          __typename        }        quantity        retailItem {          id          retailItemId          sku          title          description          slug          isOwned          creators {            displayName            __typename          }          pricing {            id            currency            listPrice            __typename          }          category {            id            name            slug            __typename          }          media(imageSizes: Small) {            images {              title              renditions {                url                imageSize                __typename              }              __typename            }            __typename          }          config {            finalSale            __typename          }          department {            title            __typename          }          objects {            id            objectTypeName            metadata {              key              value {                ... on ObjectMetadataStringValue {                  stringValue                  __typename                }                ... on ObjectMetadataStringValues {                  stringValues                  __typename                }                ... on ObjectMetadataFloatValue {                  floatValue                  __typename                }                ... on ObjectMetadataBooleanValue {                  boolValue                  __typename                }                ... on ObjectMetadataIntegerValue {                  integerValue                  __typename                }                __typename              }              __typename            }            __typename          }          shipping {            id            shipsInternationally            offeredServiceTypes            originAddress {              city              state              countryISO {                alphaTwo                englishShortNameReadingOrder                __typename              }              __typename            }            __typename          }          __typename        }        variant {          id          variantId          groupName          value          __typename        }        __typename      }      selectedRate {        id        rateId        deduplicationId        pickupDate        __typename      }      shippingRates {        id        deduplicationId        approxDelivery        description        price        rateId        serviceLevel        information        providerCode        serviceCode        __typename      }      __typename    }    __typename  }}\",\"variables\":{\"id\":\"" + bagId + "\"}}")
                .asString();

        String body = response.getBody();
        JsonShippingRate data = JSONObject.parseObject(body, JsonShippingRate.class);

        log.info("---------Response data: " + data.toString());
        return data;
    }

    public static BillingAddress getUserShippingAndBillingInfoGraphql(String token, String bagId, boolean setBillingAsShippingAddress) throws UnirestException {

        HttpResponse<String> response = Unirest.post("https://test-proxy.sothebys.cn/graphql")
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
        return billingAddress;
    }

    public static JsonItemsForReview testGetItemsForReviewGraphql(String token, String bagId) throws UnirestException {
        HttpResponse<String> response = Unirest.post("https://test-proxy.sothebys.cn/graphql")
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"query getItemsForReview($id: ID!) {  bagById(id: $id) {    id    bagId    bagItemsType    comment    pricing {      id      currency      subtotalPrice      totalPrice      tax      shippingCost      offerPrice      __typename    }    availableItemsShippingRates {      items {        id        alert {          id          unavailable          priceChange {            id            oldPrice            newPrice            __typename          }          __typename        }        availableShippingRates {          id          deduplicationId          approxDelivery          description          price          rateId          serviceLevel          information          __typename        }        quantity        retailItem {          id          retailItemId          sku          title          description          creators {            displayName            __typename          }          pricing {            id            currency            listPrice            __typename          }          media(imageSizes: Small) {            images {              title              renditions {                url                imageSize                __typename              }              __typename            }            __typename          }          config {            finalSale            __typename          }          shipping {            id            shipsInternationally            offeredServiceTypes            originAddress {              city              state              countryISO {                alphaTwo                englishShortNameReadingOrder                __typename              }              __typename            }            __typename          }          __typename        }        variant {          id          variantId          groupName          value          __typename        }        __typename      }      selectedRate {        id        rateId        deduplicationId        serviceLevel        approxDelivery        price        description        __typename      }      shippingRates {        id        deduplicationId        approxDelivery        description        price        rateId        serviceLevel        information        providerCode        serviceCode        __typename      }      __typename    }    items {      id      alert {        id        priceChange {          id          oldPrice          newPrice          __typename        }        unavailable        __typename      }      variant {        id        variantId        groupName        value        __typename      }      retailItem {        id        isOwned        retailItemId        sku        title        description        department {          id          title          __typename        }        creators {          displayName          __typename        }        objects {          id          objectTypeName          metadata {            key            value {              ... on ObjectMetadataStringValue {                stringValue                __typename              }              ... on ObjectMetadataStringValues {                stringValues                __typename              }              ... on ObjectMetadataFloatValue {                floatValue                __typename              }              ... on ObjectMetadataBooleanValue {                boolValue                __typename              }              ... on ObjectMetadataIntegerValue {                integerValue                __typename              }              __typename            }            __typename          }          __typename        }        pricing {          id          currency          listPrice          __typename        }        media(imageSizes: Small) {          images {            title            renditions {              url              imageSize              __typename            }            __typename          }          __typename        }        slug        config {          finalSale          __typename        }        department {          id          title          __typename        }        category {          id          name          slug          __typename        }        shipping {          offeredServiceTypes          originAddress {            city            state            countryISO {              alphaTwo              englishShortNameReadingOrder              __typename            }            __typename          }          __typename        }        shipping {          shipsInternationally          __typename        }        __typename      }      quantity      variant {        id        groupName        value        __typename      }      __typename    }    shippingAddress {      id      firstName      lastName      telephone      company      street1      street2      floor      countryISO {        id        alphaTwo        englishShortNameReadingOrder        __typename      }      city      state      postalCode      __typename    }    billingAddress {      street      city      stateOrProvince      postalCode      countryISO {        id        englishShortNameReadingOrder        alphaTwo        __typename      }      __typename    }    __typename  }}\",\"variables\":{\"id\":\"" + bagId + "\"}}")
                .asString();

        String body = response.getBody();
        JsonItemsForReview data = JSONObject.parseObject(body, JsonItemsForReview.class);

        log.info("---------Response data: " + data.toString());
        return data;
    }


    public static JsonDefaultBag testGetBagInfoWithShippingRateGraphql(String token, String bagId) throws IOException {
        GraphqlClient client = GraphqlClient.buildGraphqlClient("https://test-proxy.sothebys.cn/graphql");
        Map<String, String> httpHeaders = new HashMap<>();
        httpHeaders.put("authorization", token);
        client.setHttpHeaders(httpHeaders);

        GraphqlQuery query = new DefaultGraphqlQuery("bagById");

        query.addParameter("id", "bagId");

        query.addResultAttributes("id");
        query.addResultAttributes("bagId");
        query.addResultAttributes("bagItemsType");
        query.addResultAttributes("itemCount");
        query.addResultAttributes("__typename");

        ResultAttributtes pricing = new ResultAttributtes("pricing");
        pricing.addResultAttributes("id");
        pricing.addResultAttributes("currency");
        pricing.addResultAttributes("tax");
        pricing.addResultAttributes("shippingCost");
        pricing.addResultAttributes("__typename");

        ResultAttributtes availableItemsShippingRates = new ResultAttributtes("availableItemsShippingRates");


        List<ResultAttributtes> list = new ArrayList();
        ResultAttributtes shippingRates = new ResultAttributtes("shippingRates");
        shippingRates.addResultAttributes("id");
        shippingRates.addResultAttributes("deduplicationId");
        shippingRates.addResultAttributes("approxDelivery");
        shippingRates.addResultAttributes("rateId");
        shippingRates.addResultAttributes("providerCode");
        shippingRates.addResultAttributes("serviceCode");
        shippingRates.addResultAttributes("__typename");
        list.add(shippingRates);

        availableItemsShippingRates.addResultAttributes("shippingRates");

        query.addResultAttributes(pricing);

        availableItemsShippingRates.resultAttributtes = new ArrayList<>();

        ResultAttributtes items = new ResultAttributtes("items");
        items.addResultAttributes("id");
        items.addResultAttributes("quantity");
        items.addResultAttributes("__typename");

        GraphqlResponse response = client.doQuery(query);

        Map result = response.getData();
        String json = objectMapper.writeValueAsString(result);
        JsonDefaultBag jsonAddItemToBag = objectMapper.readValue(json, JsonDefaultBag.class);

        log.info("---------Response bag id: " + jsonAddItemToBag.getData());
        return jsonAddItemToBag;
    }

    @PostMapping(value = "/addRetailItemToBag")
    public static void addRetailItemToBag(String token, String itemId) throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.post("https://test-proxy.sothebys.cn/graphql")
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"    mutation addRetailItemToBag(     $retailItemId: String!     $bagId: String     $quantity: Int   ) {     addRetailItemToBag(       retailItemId: $retailItemId       bagId: $bagId       quantity: $quantity     ) {       bagId       items {         quantity         retailItemId         retailItem {           id           itemInLoggedInCart         }       }     }   } \",\"variables\":{\"retailItemId\":\"" + itemId + "\",\"bagId\":null,\"quantity\":1}}")
                .asString();

        String body = response.getBody();
        JsonAddItemToBag data = JSONObject.parseObject(body, JsonAddItemToBag.class);

        log.info("---------Response bag id: " + data.getData().getAddRetailItemToBag().getBagId());

        getBagItem(token, data.getData().getAddRetailItemToBag().getBagId());
    }


    public static void getBagItem(String token, String bagId) throws UnirestException {

        HttpResponse<String> response = Unirest.post("https://test-proxy.sothebys.cn/graphql")
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"query getBagItems($id: ID!) {  bagById(id: $id) {    id    bagId    bagItemsType    comment    itemCount    pricing {      id      currency      shippingCost      subtotalPrice      taxType      tax      totalPrice      offerPrice      __typename    }    shippingAddress {      id      countryISO {        id        alphaTwo        englishShortNameReadingOrder        __typename      }      __typename    }    items {      id      itemId      alert {        id        unavailable        __typename      }      quantity      retailItem {        id        retailItemId        sku        title        description        isOwned        availableQuantity        creators {          id          displayName          __typename        }        pricing {          id          currency          listPrice          __typename        }        media(imageSizes: Small) {          images {            title            renditions {              url              imageSize              __typename            }            __typename          }          __typename        }        config {          id          finalSale          __typename        }        objects {          id          objectTypeName          metadata {            key            value {              ... on ObjectMetadataStringValue {                stringValue                __typename              }              ... on ObjectMetadataStringValues {                stringValues                __typename              }              ... on ObjectMetadataBooleanValue {                boolValue                __typename              }              ... on ObjectMetadataIntegerValue {                integerValue                __typename              }              ... on ObjectMetadataFloatValue {                floatValue                __typename              }              __typename            }            __typename          }          __typename        }        shipping {          id          offeredServiceTypes          originAddress {            id            city            state            countryISO {              id              alphaTwo              englishShortNameReadingOrder              __typename            }            __typename          }          availableShippingDestinations {            id            alphaTwo            englishShortNameReadingOrder            __typename          }          shipsInternationally          __typename        }        __typename      }      variant {        id        variantId        groupName        value        __typename      }      __typename    }    __typename  }}\",\"variables\":{\"id\":\"" + bagId + "\"}}")
                .asString();
        String body = response.getBody();
        JsonBag data = JSONObject.parseObject(body, JsonBag.class);


        log.info("-------- Response bag id: " + data.getData().getBagById().getBagId());

        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setCountry("GB");
        shippingAddress.setFirstName("yiming");
        shippingAddress.setLastName("xie");
        shippingAddress.setTelephone("12345577");
        shippingAddress.setStreet1("sgsg");
        shippingAddress.setCity("London");
        shippingAddress.setState("London");
        shippingAddress.setPostalCode("L12");
        setShippingAddress(token, data.getData().getBagById().getBagId(), shippingAddress);
    }


    public static void setShippingAddress(String token, String bagId, ShippingAddress shippingAddress) throws UnirestException {

        HttpResponse<String> response = Unirest.post("https://test-proxy.sothebys.cn/graphql")
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"mutation setBagShippingAddress($bagId: String!, $shippingAddress: BagShippingInfoInput!) {  setBagShippingAddress(bagId: $bagId, shippingAddress: $shippingAddress) {    id    shippingChecks {      id      incompatibleShippingDestinations      invalidShippingAddressCountry      __typename    }    shippingAddress {      id      firstName      lastName      telephone      company      street1      street2      city      state      postalCode      floor      countryISO {        id        englishShortNameReadingOrder        alphaTwo        __typename      }      __typename    }    __typename  }}\",\"variables\":{\"bagId\":\"" + bagId + "\",\"shippingAddress\":{\"firstName\":\"" + shippingAddress.getFirstName() + "\",\"lastName\":\"" + shippingAddress.getLastName() + "\",\"company\":\"" + shippingAddress.getCompany() + "\",\"telephone\":\"" + shippingAddress.getTelephone() + "\",\"street1\":\"" + shippingAddress.getStreet1() + "\",\"street2\":\"" + shippingAddress.getStreet2() + "\",\"city\":\"" + shippingAddress.getCity() + "\",\"state\":\"" + shippingAddress.getState() + "\",\"postalCode\":\"" + shippingAddress.getPostalCode() + "\",\"floor\":" + shippingAddress.getFloor() + ",\"country\":\"" + shippingAddress.getCountry() + "\"}}}")
                .asString();

        String body = response.getBody();
        JsonShippingAddress data = JSONObject.parseObject(body, JsonShippingAddress.class);

        log.info("---------Response data: " + data.toString());

        getShippingRate(token, bagId);
    }

    public static void getShippingRate(String token, String bagId) throws UnirestException {

        HttpResponse<String> response = Unirest.post("https://test-proxy.sothebys.cn/graphql")
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"query getBagInfoWithShippingRate($id: ID!) {  bagById(id: $id) {    id    bagId    bagItemsType    itemCount    pricing {      id      currency      tax      shippingCost      offerPrice      __typename    }    availableItemsShippingRates {      items {        id        alert {          id          unavailable          priceChange {            id            oldPrice            newPrice            __typename          }          __typename        }        availableShippingRates {          id          deduplicationId          approxDelivery          description          price          rateId          serviceLevel          information          __typename        }        quantity        retailItem {          id          retailItemId          sku          title          description          slug          isOwned          creators {            displayName            __typename          }          pricing {            id            currency            listPrice            __typename          }          category {            id            name            slug            __typename          }          media(imageSizes: Small) {            images {              title              renditions {                url                imageSize                __typename              }              __typename            }            __typename          }          config {            finalSale            __typename          }          department {            title            __typename          }          objects {            id            objectTypeName            metadata {              key              value {                ... on ObjectMetadataStringValue {                  stringValue                  __typename                }                ... on ObjectMetadataStringValues {                  stringValues                  __typename                }                ... on ObjectMetadataFloatValue {                  floatValue                  __typename                }                ... on ObjectMetadataBooleanValue {                  boolValue                  __typename                }                ... on ObjectMetadataIntegerValue {                  integerValue                  __typename                }                __typename              }              __typename            }            __typename          }          shipping {            id            shipsInternationally            offeredServiceTypes            originAddress {              city              state              countryISO {                alphaTwo                englishShortNameReadingOrder                __typename              }              __typename            }            __typename          }          __typename        }        variant {          id          variantId          groupName          value          __typename        }        __typename      }      selectedRate {        id        rateId        deduplicationId        pickupDate        __typename      }      shippingRates {        id        deduplicationId        approxDelivery        description        price        rateId        serviceLevel        information        providerCode        serviceCode        __typename      }      __typename    }    __typename  }}\",\"variables\":{\"id\":\"" + bagId + "\"}}")
                .asString();

        String body = response.getBody();
        JsonShippingRate data = JSONObject.parseObject(body, JsonShippingRate.class);

        log.info("---------Response data: " + data.toString());

        setShippingRate(token, data.getData().getBagById().getBagId(), data.getData().getBagById().getAvailableItemsShippingRates().get(0).getItems().get(0).getRetailItem().getRetailItemId(), data.getData().getBagById().getAvailableItemsShippingRates().get(0).getShippingRates().get(0).getRateId());
    }

    public static void setShippingRate(String token, String bagId, String retailItemIds, String shippingRateId) throws UnirestException {
        HttpResponse<String> response = Unirest.post("https://test-proxy.sothebys.cn/graphql")
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"mutation setBagItemsShippingRate($bagId: String!, $retailItemIds: [String!]!, $shippingRateId: String!, $pickupDate: String) {  setBagItemsShippingRate(    bagId: $bagId    retailItemIds: $retailItemIds    shippingRateId: $shippingRateId    pickupDate: $pickupDate  ) {    id    items {      id      selectedShippingRate {        id        deduplicationId        pickupDate        __typename      }      __typename    }    __typename  }}\",\"variables\":{\"bagId\":\"" + bagId + "\",\"retailItemIds\":[\"" + retailItemIds + "\"],\"shippingRateId\":\"" + shippingRateId + "\"}}")
                .asString();

        String body = response.getBody();
        JsonSetShippingRate data = JSONObject.parseObject(body, JsonSetShippingRate.class);

        log.info("---------Response data: " + data.toString());

        getUserShippingAndBillingInfo(token, bagId);

    }


    public static void getUserShippingAndBillingInfo(String token, String bagId) throws UnirestException {

        HttpResponse<String> response = Unirest.post("https://test-proxy.sothebys.cn/graphql")
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"query getUserShippingAndBillingInfo($id: ID!) {  bagById(id: $id) {    id    bagId    itemCount    pricing {      id      currency      tax      shippingCost      __typename    }    items {      quantity      alert {        id        priceChange {          id          oldPrice          newPrice          __typename        }        unavailable        __typename      }      retailItem {        id        retailItemId        title        slug        isOwned        objects {          id          objectTypeName          metadata {            key            value {              ... on ObjectMetadataStringValue {                stringValue                __typename              }              ... on ObjectMetadataStringValues {                stringValues                __typename              }              ... on ObjectMetadataFloatValue {                floatValue                __typename              }              ... on ObjectMetadataBooleanValue {                boolValue                __typename              }              ... on ObjectMetadataIntegerValue {                integerValue                __typename              }              __typename            }            __typename          }          __typename        }        creators {          displayName          __typename        }        pricing {          id          currency          listPrice          __typename        }        media(imageSizes: Small) {          images {            renditions {              url              imageSize              __typename            }            __typename          }          __typename        }        department {          id          title          __typename        }        category {          id          name          slug          __typename        }        shipping {          shipsInternationally          __typename        }        __typename      }      variant {        id        groupName        value        __typename      }      __typename    }    shippingAddress {      id      firstName      lastName      company      telephone      street1      street2      city      state      postalCode      floor      countryISO {        id        alphaTwo        englishShortNameReadingOrder        __typename      }      __typename    }    billingAddress {      id      city      countryISO {        id        englishShortNameReadingOrder        alphaTwo        __typename      }      postalCode      stateOrProvince      street      __typename    }    __typename  }}\",\"variables\":{\"id\":\"" + bagId + "\"}}")
                .asString();

        String body = response.getBody();
        JsonUserShippingAndBillingInfo data = JSONObject.parseObject(body, JsonUserShippingAndBillingInfo.class);

        log.info("---------Response data: " + data.toString());


        BillingAddress billingAddress = new BillingAddress();

        boolean setBillingAsShippingAddress = true;


        if (setBillingAsShippingAddress) {
            billingAddress.setCountry(data.getData().getBagById().getShippingAddress().getCountryISO().getAlphaTwo());
            billingAddress.setCity(data.getData().getBagById().getShippingAddress().getCity());
            billingAddress.setStreet(data.getData().getBagById().getShippingAddress().getStreet1() + " " + data.getData().getBagById().getShippingAddress().getStreet2() + " " + data.getData().getBagById().getShippingAddress().getFloor());
            billingAddress.setStateOrProvince(data.getData().getBagById().getShippingAddress().getState());
            billingAddress.setPostalCode(data.getData().getBagById().getShippingAddress().getPostalCode());
        } else {
            billingAddress.setCountry("GB");
            billingAddress.setCity("London");
            billingAddress.setStreet("sgag");
            billingAddress.setStateOrProvince("London");
            billingAddress.setPostalCode("L12");
        }

        setBagBillingAddress(token, data.getData().getBagById().getBagId(), billingAddress);
    }


    public static void setBagBillingAddress(String token, String bagId, BillingAddress billingAddress) throws UnirestException {

        HttpResponse<String> response = Unirest.post("https://test-proxy.sothebys.cn/graphql")
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"mutation setBagBillingAddress($bagId: String!, $billingAddress: BagBillingInfoInput!) {  setBagBillingAddress(bagId: $bagId, billingAddress: $billingAddress) {    id    billingAddress {      id      street      city      stateOrProvince      postalCode      countryISO {        id        englishShortNameReadingOrder        alphaTwo        __typename      }      __typename    }    __typename  }}\",\"variables\":{\"bagId\":\"" + bagId + "\",\"billingAddress\":{\"street\":\"" + billingAddress.getStreet() + "\",\"city\":\"" + billingAddress.getCity() + "\",\"stateOrProvince\":\"" + billingAddress.getStateOrProvince() + "\",\"postalCode\":\"" + billingAddress.getPostalCode() + "\",\"country\":\"" + billingAddress.getCountry() + "\"}}}")
                .asString();

        String body = response.getBody();
        JsonBillingAddress data = JSONObject.parseObject(body, JsonBillingAddress.class);

        log.info("---------Response data: " + data.toString());

        getItemsForReview(token, bagId);
    }

    public static void getItemsForReview(String token, String bagId) throws UnirestException {
        HttpResponse<String> response = Unirest.post("https://test-proxy.sothebys.cn/graphql")
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body("{\"query\":\"query getItemsForReview($id: ID!) {  bagById(id: $id) {    id    bagId    bagItemsType    comment    pricing {      id      currency      subtotalPrice      totalPrice      tax      shippingCost      offerPrice      __typename    }    availableItemsShippingRates {      items {        id        alert {          id          unavailable          priceChange {            id            oldPrice            newPrice            __typename          }          __typename        }        availableShippingRates {          id          deduplicationId          approxDelivery          description          price          rateId          serviceLevel          information          __typename        }        quantity        retailItem {          id          retailItemId          sku          title          description          creators {            displayName            __typename          }          pricing {            id            currency            listPrice            __typename          }          media(imageSizes: Small) {            images {              title              renditions {                url                imageSize                __typename              }              __typename            }            __typename          }          config {            finalSale            __typename          }          shipping {            id            shipsInternationally            offeredServiceTypes            originAddress {              city              state              countryISO {                alphaTwo                englishShortNameReadingOrder                __typename              }              __typename            }            __typename          }          __typename        }        variant {          id          variantId          groupName          value          __typename        }        __typename      }      selectedRate {        id        rateId        deduplicationId        serviceLevel        approxDelivery        price        description        __typename      }      shippingRates {        id        deduplicationId        approxDelivery        description        price        rateId        serviceLevel        information        providerCode        serviceCode        __typename      }      __typename    }    items {      id      alert {        id        priceChange {          id          oldPrice          newPrice          __typename        }        unavailable        __typename      }      variant {        id        variantId        groupName        value        __typename      }      retailItem {        id        isOwned        retailItemId        sku        title        description        department {          id          title          __typename        }        creators {          displayName          __typename        }        objects {          id          objectTypeName          metadata {            key            value {              ... on ObjectMetadataStringValue {                stringValue                __typename              }              ... on ObjectMetadataStringValues {                stringValues                __typename              }              ... on ObjectMetadataFloatValue {                floatValue                __typename              }              ... on ObjectMetadataBooleanValue {                boolValue                __typename              }              ... on ObjectMetadataIntegerValue {                integerValue                __typename              }              __typename            }            __typename          }          __typename        }        pricing {          id          currency          listPrice          __typename        }        media(imageSizes: Small) {          images {            title            renditions {              url              imageSize              __typename            }            __typename          }          __typename        }        slug        config {          finalSale          __typename        }        department {          id          title          __typename        }        category {          id          name          slug          __typename        }        shipping {          offeredServiceTypes          originAddress {            city            state            countryISO {              alphaTwo              englishShortNameReadingOrder              __typename            }            __typename          }          __typename        }        shipping {          shipsInternationally          __typename        }        __typename      }      quantity      variant {        id        groupName        value        __typename      }      __typename    }    shippingAddress {      id      firstName      lastName      telephone      company      street1      street2      floor      countryISO {        id        alphaTwo        englishShortNameReadingOrder        __typename      }      city      state      postalCode      __typename    }    billingAddress {      street      city      stateOrProvince      postalCode      countryISO {        id        englishShortNameReadingOrder        alphaTwo        __typename      }      __typename    }    __typename  }}\",\"variables\":{\"id\":\"" + bagId + "\"}}")
                .asString();

        String body = response.getBody();
        JsonItemsForReview data = JSONObject.parseObject(body, JsonItemsForReview.class);

        log.info("---------Response data: " + data.toString());

    }


    public static JsonPurchase purchaseOrder(JsonItemsForReview data) throws UnirestException {
        JsonPurchase jsonPurchase = new JsonPurchase();
        log.info(jsonPurchase.toString());
        return jsonPurchase;
    }

}
