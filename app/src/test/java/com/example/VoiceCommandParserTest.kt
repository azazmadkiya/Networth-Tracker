package com.example

import com.example.data.model.ItemCategory
import com.example.data.model.ReminderType
import com.example.ui.viewmodel.ParsedVoiceAction
import com.example.ui.viewmodel.VoiceCommandParser
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class VoiceCommandParserTest {

    @Test
    fun testParseAddAccount() {
        val action = VoiceCommandParser.parse("Add account HDFC Bank 50000")
        assertTrue(action is ParsedVoiceAction.AddAccountAction)
        val accountAction = action as ParsedVoiceAction.AddAccountAction
        assertEquals("HDFC Bank", accountAction.accountItem.title)
        assertEquals(50000.0, accountAction.initialBalance, 0.01)
        assertEquals(ItemCategory.BANK_ACCOUNT.displayName, accountAction.accountItem.category)
    }

    @Test
    fun testParseAddBankAccountWithBalance() {
        val action = VoiceCommandParser.parse("Add bank account SBI with balance 25000")
        assertTrue(action is ParsedVoiceAction.AddAccountAction)
        val accountAction = action as ParsedVoiceAction.AddAccountAction
        assertEquals("SBI", accountAction.accountItem.title)
        assertEquals(25000.0, accountAction.initialBalance, 0.01)
    }

    @Test
    fun testParseAddReminder() {
        val action = VoiceCommandParser.parse("Add reminder pay electricity bill 1500 tomorrow")
        assertTrue(action is ParsedVoiceAction.AddReminderAction)
        val reminderAction = action as ParsedVoiceAction.AddReminderAction
        assertEquals(1500.0, reminderAction.reminder.amount, 0.01)
        assertEquals(ReminderType.DUE_DATE.name, reminderAction.reminder.reminderType)
    }

    @Test
    fun testParseAddExpenseFinancialEntry() {
        val action = VoiceCommandParser.parse("Add expense 450 groceries")
        assertTrue(action is ParsedVoiceAction.AddLedgerAction)
        val ledgerAction = action as ParsedVoiceAction.AddLedgerAction
        assertEquals(450.0, ledgerAction.entry.debitAmount, 0.01)
        assertEquals("Groceries", ledgerAction.entry.transactionTitle)
    }

    @Test
    fun testParseAddIncomeFinancialEntry() {
        val action = VoiceCommandParser.parse("Add income 80000 salary")
        assertTrue(action is ParsedVoiceAction.AddLedgerAction)
        val ledgerAction = action as ParsedVoiceAction.AddLedgerAction
        assertEquals(80000.0, ledgerAction.entry.creditAmount, 0.01)
        assertEquals("Salary", ledgerAction.entry.transactionTitle)
    }

    @Test
    fun testParseAddAssetFinancialEntry() {
        val action = VoiceCommandParser.parse("Add asset Reliance stock 50000")
        assertTrue(action is ParsedVoiceAction.AddFinancialItemAction)
        val itemAction = action as ParsedVoiceAction.AddFinancialItemAction
        assertEquals(50000.0, itemAction.item.currentValue, 0.01)
        assertEquals(false, itemAction.item.isLiability)
    }

    @Test
    fun testParseAddSipReminder() {
        val action = VoiceCommandParser.parse("Remind SIP 5000 on 5th")
        assertTrue(action is ParsedVoiceAction.AddReminderAction)
        val reminderAction = action as ParsedVoiceAction.AddReminderAction
        assertEquals(5000.0, reminderAction.reminder.amount, 0.01)
        assertEquals(ReminderType.SIP_INVESTMENT.name, reminderAction.reminder.reminderType)
    }

    @Test
    fun testParseAddLiability() {
        val action = VoiceCommandParser.parse("Add liability car loan 350000")
        assertTrue(action is ParsedVoiceAction.AddFinancialItemAction)
        val itemAction = action as ParsedVoiceAction.AddFinancialItemAction
        assertEquals(350000.0, itemAction.item.currentValue, 0.01)
        assertEquals(true, itemAction.item.isLiability)
    }
}
