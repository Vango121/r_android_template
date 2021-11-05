package com.example.r_android_template

import com.example.r_android_template.service.Service
import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}

class ServiceObjectTest {
    val model = Service.returnServiceObject()
    @Test
    fun checkData(){
        assertEquals(model[0].id,1)
        assertEquals(model[0].estateNo,"123456/5432")
        assertEquals(model[0].area,23.1242312312435345)
        assertEquals(model[0].land,"Nordrhein-Westfale")
        assertEquals(model[0].district,"Wertheim")
    }
    @Test
    fun is_array_size_correct(){
        assertEquals(model.size,15)
    }

}