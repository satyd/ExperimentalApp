package com.levp.experimentalapp.implementation

import android.util.Log
import com.levp.experimentalapp.interfaces.ExperimentalAction

class RandomExperimentalAction : ExperimentalAction {
    override fun startAction() {
        TODO("Not yet implemented")
    }

    override fun stopAction() {
        TODO("Not yet implemented")
    }

    override fun experimentalFun1(): Nothing {
        Log.d("hehe","THE (not so) GREAT CRASH IS COMING!!!!")

        return TODO("Provide the return value")
    }

    override fun experimentalFun2(): Void {
        TODO("Not yet implemented")
    }

    override fun experimentalFun3(): Any {
        return 5
    }

}