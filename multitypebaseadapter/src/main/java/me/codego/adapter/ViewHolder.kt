package me.codego.adapter

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by mengxn on 2017/9/21.
 */
open class ViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    var data: T? = null

    private val mViews: SparseArray<View> by lazy { SparseArray<View>() }

    fun bind(typeData: ITypeFactory.TypeData<T>, data: T) {
        this.data = data
        typeData.bind(this)
    }

    fun setText(id: Int, text: CharSequence?) {
        getView<TextView>(id).text = text
    }

    fun setImageResource(id: Int, resId: Int) {
        getView<ImageView>(id).setImageResource(resId)
    }

    fun setBackground(id: Int, resId: Int) {
        getView<View>(id).setBackgroundResource(resId)
    }

    fun setBackgroundColor(id: Int, color: Int) {
        getView<View>(id).setBackgroundColor(color)
    }

    fun setVisibility(id: Int, visibility: Int) {
        getView<View>(id).visibility = visibility
    }

    fun setOnClickListener(id: Int, listener: View.OnClickListener) {
        getView<View>(id).setOnClickListener(listener)
    }

    fun <R: View> getView(id: Int): R {
        return mViews.get(id) as? R ?: itemView.findViewById<R>(id).also {
            mViews.put(id, it)
        }
    }
}





