OkRest
======

OkRest is a fluent REST client that is built on Square's excellent [OkHttp](https://square.github.io/okhttp/) client.

OkRest's API is similar in construction JAX-RS, but without all of the JAX-RS baggage.


Examples
--------

Assuming that a ficticious service with a GET request for ```/api/users/123``` returns:
```json
{
  "id" : 123,
  "name" : "Rob"
}
```

This will get the body as a String:

```java
String body = new OkRestClient()
    .uri("https://api.example.com")
    .path("/api/users/123")
    .get().execute(String.class);
```

And if we want to parse it through Jackson's fluent tree API:

```java
String name = new OkRestClient()
    .uri("https://api.example.com")
    .path("/api/users/123")
    .get().execute(JsonNode.class)
    .path("name").asText();
```