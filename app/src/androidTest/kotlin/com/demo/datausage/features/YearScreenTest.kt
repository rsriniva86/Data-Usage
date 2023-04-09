package com.demo.datausage.features

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.demo.datausage.MainActivity
import org.junit.Rule
import org.junit.Test

class YearScreenTest {

    @Rule
    @JvmField
    var composeTestRule: ComposeContentTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testYearScreen() {
        composeTestRule.onNodeWithText("Year Screen").assertTextEquals("Year Screen")
        composeTestRule.waitUntil(5000L) {
            composeTestRule
                .onAllNodesWithTag("2005")
                .fetchSemanticsNodes().size == 1
        }
        composeTestRule.onNodeWithTag("2005").assertTextContains("Year : 2005")
        composeTestRule.onNodeWithTag("2005").assertTextContains("Usage : 0.002773")
        composeTestRule.onNodeWithTag("2004").assertTextContains("Year : 2004")
        composeTestRule.onNodeWithTag("2006").assertTextContains("Year : 2006")

    }
}