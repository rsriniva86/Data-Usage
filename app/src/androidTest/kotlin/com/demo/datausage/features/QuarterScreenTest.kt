package com.demo.datausage.features

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.demo.datausage.MainActivity
import org.junit.Rule
import org.junit.Test

class QuarterScreenTest {
    @Rule
    @JvmField
    var composeTestRule: ComposeContentTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testQuarterScreen() {
        composeTestRule.onNodeWithText("Year Screen").assertTextEquals("Year Screen")
        composeTestRule.waitUntil(5000L) {
            composeTestRule
                .onAllNodesWithTag("2005")
                .fetchSemanticsNodes().size == 1
        }
        composeTestRule.onNodeWithTag("2006").assertTextContains("Year : 2006")
        composeTestRule.onNodeWithTag("2006").performClick()
        composeTestRule.waitUntil(5000L) {
            composeTestRule
                .onAllNodesWithTag("YEAR_TAG" + 2007)
                .fetchSemanticsNodes().size == 1
        }
        composeTestRule.onNodeWithText("Year Details Screen")
            .assertTextEquals("Year Details Screen")
        composeTestRule.onNodeWithTag("YEAR_TAG" + 2007).assertTextEquals("2007")
        composeTestRule.onNodeWithTag("Q1_TAG" + 2007).assertTextContains("Q1 : 0.012635")
        composeTestRule.onNodeWithTag("Q2_TAG" + 2007).assertTextContains("Q2 : 0.029992")
        composeTestRule.onNodeWithTag("Q3_TAG" + 2007).assertTextContains("Q3 : 0.053584")
        composeTestRule.onNodeWithTag("Q4_TAG" + 2007).assertTextContains("Q4 : 0.100934")

    }
}