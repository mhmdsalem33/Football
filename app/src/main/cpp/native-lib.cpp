#include <jni.h>
#include <string>

extern "C" {
JNIEXPORT jstring JNICALL
Java_com_sa_football_data_di_NetworkModule_getEncryptedBaseUrl(JNIEnv *env, jobject object) {
    std::string encrypted_base_url = "https://api.football-data.org/v4/";

    return env->NewStringUTF(encrypted_base_url.c_str());
}





//JNIEXPORT jstring JNICALL
//Java_com_sa_glamera_data_di_NetworkModule_getEncryptedTwoAPI(JNIEnv *env, jobject object) {
//    std::string encrypted_two_api = "Salem with c++ two";
//    return env->NewStringUTF(encrypted_two_api.c_str());
//}
}
