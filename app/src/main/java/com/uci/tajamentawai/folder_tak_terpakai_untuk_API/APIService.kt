import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

// Data Models (sesuaikan dengan struktur respons Anda)
data class User(val id: String, val name: String, val email: String)
data class Article(val id: String, val title: String, val content: String)
data class Comment(val id: String, val content: String)
data class ApiResponse<T>(val success: Boolean, val data: T?, val message: String?)

// API Service
interface ApiService {

    // AUTH
    @POST("register")
    suspend fun register(@Body user: User): Response<ApiResponse<User>>

    @POST("login")
    suspend fun login(@Body credentials: Map<String, String>): Response<ApiResponse<User>>

    @GET("auth/google")
    suspend fun loginWithGoogle(): Response<ApiResponse<User>>

    @GET("users/me")
    suspend fun getUserDetails(): Response<ApiResponse<User>>

    @PUT("users/{id}/role")
    suspend fun updateUserRole(@Path("id") id: String, @Body role: Map<String, String>): Response<ApiResponse<User>>

    @DELETE("delete-user")
    suspend fun deleteUser(): Response<ApiResponse<Any>>

    @POST("logout")
    suspend fun logout(): Response<ApiResponse<Any>>

    @PUT("change-password")
    suspend fun changePassword(@Body passwordData: Map<String, String>): Response<ApiResponse<Any>>

    @POST("request-password")
    suspend fun requestPasswordReset(@Body emailData: Map<String, String>): Response<ApiResponse<Any>>

    @POST("reset-password")
    suspend fun resetPassword(@Body passwordData: Map<String, String>): Response<ApiResponse<Any>>

    // ARTICLE
    @POST("tambah-artikel")
    suspend fun createArticle(@Body article: Article): Response<ApiResponse<Article>>

    @GET("artikel")
    suspend fun getAllArticles(): Response<ApiResponse<List<Article>>>

    @GET("artikel/author/{author_id}")
    suspend fun getArticlesByAuthor(@Path("author_id") authorId: String): Response<ApiResponse<List<Article>>>

    @GET("artikel/{id}")
    suspend fun getArticleById(@Path("id") articleId: String): Response<ApiResponse<Article>>

    @PATCH("update-artikel/{id}")
    suspend fun updateArticle(@Path("id") articleId: String, @Body article: Article): Response<ApiResponse<Article>>

    @DELETE("delete-artikel")
    suspend fun deleteArticle(@Body articleId: Map<String, String>): Response<ApiResponse<Any>>

    @DELETE("artikel/{id}/delete-image")
    suspend fun deleteArticleImage(@Path("id") articleId: String): Response<ApiResponse<Any>>

    // COMMENT
    @POST("tambah-komentar/{article_id}")
    suspend fun addComment(@Path("article_id") articleId: String, @Body comment: Comment): Response<ApiResponse<Comment>>

    @DELETE("hapus-komentar/{id}")
    suspend fun deleteComment(@Path("id") commentId: String): Response<ApiResponse<Any>>

    @PATCH("update-komentar/{id}")
    suspend fun updateComment(@Path("id") commentId: String, @Body comment: Comment): Response<ApiResponse<Comment>>
}
