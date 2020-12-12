//
// Created by Prissy on 07/12/2020.
//

#include <jni.h>
#include <stdlib.h>
#include <time.h>
#include <string>

extern "C"
JNIEXPORT jint JNICALL
Java_id_ac_ui_cs_mobileprogramming_prissy_helloworld_external_Sum_addSum(JNIEnv *env, jobject thiz,
                                                                         jint first, jint second) {
    return first + second;
}

