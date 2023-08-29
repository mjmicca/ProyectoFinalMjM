package com.curso.android.app.prectica.proyectofinalmjm


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.prectica.proyectofinalmjm.view.MainViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {
    private lateinit var viewModel:MainViewModel

    @get:Rule
    val instantTaskRule= InstantTaskExecutorRule()
    private  val dispatcher=StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel= MainViewModel()
    }
    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue()= runTest {
        val value=viewModel.comparacion.value?.resultado
        assertEquals("",value)
    }

    @Test
    fun mainViewModel_ButtonIguales()= runTest {
       launch {
           viewModel.compara("algo","algo")
       }
        advanceUntilIdle()
        val value=viewModel.comparacion.value?.resultado
        assertEquals("Los textos SON IGUALES",value)
    }
    @Test
    fun mainViewModel_ButtonNoIguales()= runTest {
        launch {
            viewModel.compara("algo","distinto")
        }
        advanceUntilIdle()
        val value=viewModel.comparacion.value?.resultado
        assertEquals("Los textos NO SON IGUALES",value)
    }

}