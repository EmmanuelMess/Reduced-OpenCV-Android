#include <jni.h>
#include <string>
#include <opencv2/core.hpp>

using namespace cv;

extern "C" JNIEXPORT jstring JNICALL
Java_com_emmanuelmess_opencvstatictest_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";

    Mat a;

    return env->NewStringUTF(hello.c_str());
}
