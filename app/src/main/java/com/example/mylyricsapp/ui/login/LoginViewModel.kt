package com.example.mylyricsapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mylyricsapp.R
import com.example.mylyricsapp.base.BaseViewModel

class LoginViewModel : BaseViewModel() {
    /*

    Criando classe para monitorar a situação
    do usuruario se ele esta autenticado ou não

     */
    sealed class AuthenticateState {
        object Authenticated : AuthenticateState()
        object Unauthenticated : AuthenticateState()
        class InvalidAuthentication(val fields: List<Pair<String, Int>>) : AuthenticateState()
    }

    private var userName = ""
    private var password = ""

    //Inicializando  variavel de estado de forma segura para que a variavel fique protegida
    private val _authenticatedStateEvent = MutableLiveData<AuthenticateState>()
    val authenticateStateEvent: LiveData<AuthenticateState>
        get() = _authenticatedStateEvent

    //Resetando a autentificação toda vez ao iniciar

    init {
        refuseAuthentication()
    }

    fun refuseAuthentication() {
        _authenticatedStateEvent.value = AuthenticateState.Unauthenticated
    }

    /*
    Implementando a regra de Autentificação
     */

    fun authentication(userName: String, password: String) {
        if (isValidForm(userName, password)) {
            this.userName = userName
            _authenticatedStateEvent.value = AuthenticateState.Authenticated
        }
    }

    private fun isValidForm(userName: String, password: String): Boolean {
        val invalidFields = arrayListOf<Pair<String, Int>>()

        if (userName.isEmpty()) {
            invalidFields.add(INPUT_USERNAME)
        }

        if (password.isEmpty()) {
            invalidFields.add(INPUT_PASSWORD)
        }

        if (invalidFields.isNotEmpty()) {
            _authenticatedStateEvent.value = AuthenticateState.InvalidAuthentication(invalidFields)
            return false
        }

        return true
    }

    fun auth(){
        _authenticatedStateEvent.value = AuthenticateState.Authenticated
    }

    companion object {
        val INPUT_PASSWORD = "INPUT_PASSWORD" to R.string.invalid_password
        val INPUT_USERNAME = "INPUT_USERNAME" to R.string.invalid_username
    }

}