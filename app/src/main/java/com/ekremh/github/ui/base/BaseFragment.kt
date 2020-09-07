package com.ekremh.github.ui.base
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : BasePresenter>: Fragment(), BaseView<T> {

    abstract val layoutId: Int

    abstract val presenter: T

    protected val baseActivity: BaseActivity<*>?
        get() {
            return activity as? BaseActivity<*>
        }


    abstract fun initializeUI()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(layoutId,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
        presenter.initialize(arguments)
    }

    override fun onDestroyView() {
        presenter.finalizeView()
        super.onDestroyView()
    }

    override fun toastMessage(message: String) {
        baseActivity?.toastMessage(message)
    }
}