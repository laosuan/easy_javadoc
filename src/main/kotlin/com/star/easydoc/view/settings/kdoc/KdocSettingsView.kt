package com.star.easydoc.view.settings.kdoc

import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.diagnostic.Logger
import com.star.easydoc.config.EasyDocConfigComponent
import com.star.easydoc.service.translator.TranslatorService
import com.star.easydoc.view.settings.CommonSettingsView
import org.apache.commons.lang3.BooleanUtils
import javax.swing.*
import javax.swing.event.ChangeEvent

/**
 * @author wangchao
 * @date 2022/12/04
 */
class KdocSettingsView {

    private val config = ServiceManager.getService(EasyDocConfigComponent::class.java).state!!

    private lateinit var panel: JPanel
    private lateinit var authorTextField: JTextField
    private lateinit var dateFormatTextField: JTextField
    private lateinit var classPanel: JPanel
    private lateinit var fieldPanel: JPanel
    private lateinit var authorLabel: JLabel
    private lateinit var dataFormatLabel: JLabel
    private lateinit var simpleDocButton: JRadioButton
    private lateinit var normalDocButton: JRadioButton
    private lateinit var fieldDocLabel: JLabel
    private lateinit var methodPanel: JPanel
    private lateinit var commonPanel: JPanel
    private lateinit var kdocParamTypeBox: JComboBox<*>
    private lateinit var kdocParamTypeLabel: JLabel

    init {
        simpleDocButton.addChangeListener { e: ChangeEvent ->
            val button = e.source as JRadioButton
            if (button.isSelected) {
                normalDocButton.isSelected = false
            } else {
                normalDocButton.isSelected = true
            }
        }
        normalDocButton.addChangeListener { e: ChangeEvent ->
            val button = e.source as JRadioButton
            if (button.isSelected) {
                simpleDocButton.isSelected = false
            } else {
                simpleDocButton.isSelected = true
            }
        }
    }

    private fun createUIComponents() {

    }

    val component: JComponent
        get() = panel

    fun setSimpleDocButton(b: Boolean) {
        simpleDocButton.isSelected = b
    }

    fun setNormalDocButton(b: Boolean) {
        normalDocButton.isSelected = b
    }

    fun setAuthorTextField(author: String?) {
        authorTextField.text = author
    }


    fun setDateFormatTextField(dateFormat: String?) {
        dateFormatTextField.text = dateFormat
    }
}