package com.dockerproject.restapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

@RestController
class MainController @Autowired constructor(
        private val jdbcTemplate: JdbcTemplate
){
    @GetMapping("/{username}/filter")
    fun getFilterForUser(@PathVariable("username") username: String): Map<String, Any> {
        val filter = jdbcTemplate.queryForMap(
                "select filters.* from filters " +
                        "join users on user_id=id " +
                        "where username='${username}'");
        return filter
    }

    @PutMapping("/{username}/filter")
    fun updateFilterForUser(@PathVariable("username") username: String, @RequestBody body: Map<String, Any>) {
        jdbcTemplate.execute("update filters set " +
                "area='${body["area"]}', " +
                "min_total_price='${body["min_total_price"]}', " +
                "max_total_price='${body["max_total_price"]}', " +
                "min_size='${body["min_size"]}', " +
                "max_size='${body["max_size"]}', " +
                "n_bedrooms='${body["n_bedrooms"]}', " +
                "owner_type='${body["owner_type"]}' " +
                "FROM users WHERE username='${username}' returning 'hi'")
    }

    @GetMapping("/users")
    fun getUsers(): List<Any> {
        val filter = jdbcTemplate.queryForList( "select * from users");
        return filter
    }
}


@SpringBootApplication
class RestapiApplication

fun main(args: Array<String>) {
    SpringApplication.run(RestapiApplication::class.java, *args)
}
