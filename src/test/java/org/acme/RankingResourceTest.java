package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class RankingResourceTest {

    @Test
    public void test1995topSongs() {
        given()
          .when().get("/ranking/songs/1995")
          .then()
             .statusCode(200);
    }

}