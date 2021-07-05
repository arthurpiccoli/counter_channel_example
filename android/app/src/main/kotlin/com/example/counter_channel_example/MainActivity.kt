package com.example.counter_channel_example

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        val calculatorChannel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "calculator")

        calculatorChannel.setMethodCallHandler { call, result ->
            when (call.method) {
                "increment" -> {
                    var value = call.arguments as Int
                    value++
                    result.success(value)
                }
                else -> result.notImplemented()
            }
        }
    }
}
