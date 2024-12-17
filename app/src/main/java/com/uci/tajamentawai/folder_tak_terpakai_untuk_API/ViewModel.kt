
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val api = ApiClient.instance

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> = _articles

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    fun fetchArticles() {
        viewModelScope.launch {
            try {
                val response = api.getAllArticles()
                if (response.isSuccessful && response.body()?.success == true) {
                    _articles.value = response.body()?.data ?: emptyList()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = api.login(mapOf("email" to email, "password" to password))
                if (response.isSuccessful && response.body()?.success == true) {
                    _user.value = response.body()?.data
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
