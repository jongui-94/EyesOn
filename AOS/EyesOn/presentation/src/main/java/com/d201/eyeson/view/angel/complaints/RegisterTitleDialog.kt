package com.d201.eyeson.view.angel.complaints

import com.d201.domain.model.Complaints
import com.d201.eyeson.R
import com.d201.eyeson.base.BaseDialogFragment
import com.d201.eyeson.databinding.DialogRegisterTitleBinding
import com.d201.eyeson.view.angel.TitleConfirmListener

private const val TAG = "RegisterTitleDialog"

class RegisterTitleDialog(
    private val complaints: Complaints,
    private val titleConfirmListener: TitleConfirmListener
) : BaseDialogFragment<DialogRegisterTitleBinding>(R.layout.dialog_register_title) {
    override fun init() {
        initListener()
    }

    private fun initListener() {
        binding.apply {
            btnConfirm.setOnClickListener {
                if (etTitle.text.isNotBlank()) {
                    complaints.title = etTitle.text.toString()
                    titleConfirmListener.onClick(complaints)
                    dismiss()
                } else {
                    showToast("민원 제목을 입력해주세요")
                }
            }
            btnCancel.setOnClickListener {
                dismiss()
            }
        }
    }

}
