package com.levp.experimentalapp.presentation.dialog

sealed class EnchantedDialogOutput {
    object ClickOne : EnchantedDialogOutput()
    object ClickTwo : EnchantedDialogOutput()

    class HeavyClick(val weight: Int) : EnchantedDialogOutput()
}