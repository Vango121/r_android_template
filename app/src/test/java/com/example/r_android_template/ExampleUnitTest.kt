package com.example.r_android_template

import android.content.Context
import androidx.lifecycle.*
import androidx.test.core.app.ApplicationProvider
import com.example.r_android_template.data.Repository
import com.example.r_android_template.service.Service
import com.example.r_android_template.view.fragments.homeFragment.HomeViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

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
        assertEquals(1,model[0].id)
        assertEquals("123456/5432",model[0].estateNo)
        assertEquals(23.1242312312435345,model[0].area)
        assertEquals("Nordrhein-Westfale",model[0].land)
        assertEquals("Wertheim",model[0].district)
    }
    @Test
    fun is_array_size_correct(){
        assertEquals(model.size,15)
    }

}
class OneTimeObserver<T>(private val handler: (T) -> Unit) : Observer<T>, LifecycleOwner {
    private val lifecycle = LifecycleRegistry(this)

    init {
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun getLifecycle(): Lifecycle = lifecycle

    override fun onChanged(t: T) {
        handler(t)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }
}
@RunWith(
    RobolectricTestRunner::class)
class RepositoryTest{
//    lateinit var instrumentationContext: Context
    private lateinit var viewmodel : HomeViewModel
    val context = ApplicationProvider.getApplicationContext<Context>()
    @Before
    fun setup(){
        viewmodel = HomeViewModel(Repository(context))
        viewmodel.saveID(3)
    }
    fun <T> LiveData<T>.observeOnce(onChangeHandler: (T) -> Unit) {
        val observer = OneTimeObserver(handler = onChangeHandler)
        observe(observer, observer)
    }
    @Test
    fun is_data_saving(){
        viewmodel.getID()
        viewmodel.idLiveData.observeOnce{
            assertEquals(3,it)
        }

    }
}