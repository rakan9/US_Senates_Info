package safcsp.android.usenatesinfo.api

import retrofit2.http.GET
import retrofit2.http.Query
import safcsp.android.usenatesinfo.senatesdata.Meta

interface USSenatesApi {

    @GET ("SenatesInfo.json")
    fun fetchSenatorsInfo(
        @Query("meta") metadata: Meta,
        @Query("Object") object1: Object
    )
}