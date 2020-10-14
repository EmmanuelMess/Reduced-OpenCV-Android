# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

include_directories(${OpenCV_DIR}/jni/include)

set(STATIC_LIBS "${OpenCV_DIR}/staticlibs/${ANDROID_ABI}")

file(GLOB STUFF RELATIVE ${STATIC_LIBS} ${STATIC_LIBS}/*.a)

foreach(lib ${STUFF})
    add_library( ${lib} STATIC IMPORTED )
    set_target_properties(${lib} PROPERTIES IMPORTED_LOCATION ${STATIC_LIBS}/${lib})
endforeach()


set(STATIC_LIBS_OTHER "${OpenCV_DIR}/3rdparty/libs/${ANDROID_ABI}")

file(GLOB STUFF_OTHER RELATIVE ${STATIC_LIBS_OTHER} ${STATIC_LIBS_OTHER}/*.a)

foreach(lib_other ${STUFF_OTHER})
    message(WARNING "${lib_other}")
    add_library( ${lib_other} STATIC IMPORTED )
    set_target_properties(${lib_other} PROPERTIES IMPORTED_LOCATION ${STATIC_LIBS_OTHER}/${lib_other})
endforeach()



add_library( native-lib SHARED native-lib.cpp)

find_library(
        log-lib
        log
)


target_link_libraries(
        native-lib
        ${STUFF}
        ${STUFF_OTHER}
        ${log-lib}
)