package com.aula_testes.jsonparser

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.json.JSONArray
import org.json.JSONObject
import org.junit.Assert.*
import org.junit.Test

class ParserJsonTest {


    @Test
    fun test_arrayObject() {
        val jsonString = """
        [{
        
        "name":"Fulano",
        "age":23,
        "gender":"Male",
        "is_active":false
        },
        {
        
        "name":"Beltrano",
        "age":23,
        "gender":"Male",
        "is_active":false
        }
        ]
        """

        val jsonArray = JSONArray(jsonString)

        for (index: Int in 0 until jsonArray.length()) {
            println(jsonArray.getJSONObject(index))

        }

    }


    @Test

    fun test_JsonObject() {


        val jsonString = """
        {
        
        "name":"Fulano",
        "age":23,
        "gender":"Male",
        "is_active":false
        }
        """

        var jsonObject = JSONObject(jsonString)

        val person = Person(jsonObject)

        print(" Name is ${person.name}")

    }


    @Test
    fun whenSerializePerson_thenSuccess() {
        val mapper = jacksonObjectMapper()
        val person = Person("Ciclano", 23, "M")
        val valueAsString = mapper.writeValueAsString(person)


        print("Person is ${valueAsString}")


    }

    @Test
    fun whenDeserializePerson_thenSuccess() {

        val mapper = jacksonObjectMapper()

        val jsonString = """
        {
        
        "name":"Fulano",
        "age":23,
        "gender":"Male",
        "is_active":false
        }
        """


        val person = mapper.readValue<Person>(jsonString)


        print("Person is ${person.name}")


    }
}

