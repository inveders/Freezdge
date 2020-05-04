package com.inved.freezdge.recipes.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.inved.freezdge.R


class CustomExpandableListAdapter(
    private val _context: Context, // header titles
    private val _listDataHeader: List<String>,
    // child data in format of header title, child title
    private val _listDataChild: HashMap<String, List<String>>

) : BaseExpandableListAdapter() {

    override fun getChild(groupPosition: Int, childPosititon: Int): String {
        Log.d("debago", "group position is $groupPosition and chil position is $childPosititon")
        return _listDataChild[_listDataHeader[groupPosition]]!![childPosititon]
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }


    override fun getChildrenCount(parent: Int): Int {
        Log.d("debago","get children coun is ${_listDataChild[_listDataHeader[parent]]!!.size}")
        return _listDataChild[_listDataHeader[parent]]!!.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return _listDataHeader[groupPosition]
    }

    override fun getGroupCount(): Int {
        return _listDataHeader.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(
        parent: Int,
        isExpanded: Boolean,
        convertView: View?,
        parentview: ViewGroup
    ): View {
        var convertView: View? = convertView

        if (convertView == null) {
            val inflater =
                _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(
                R.layout.item_recipe_detail_list_expandable_group,
                parentview,
                false
            )

        }

        val parent_textvew = convertView!!.findViewById(R.id.listTitle) as TextView
        parent_textvew.text = _listDataHeader[parent]
        return convertView
    }

    override fun getChildView(
        parent: Int,
        child: Int,
        isLastChild: Boolean,
        convertview: View?,
        parentview: ViewGroup
    ): View {
        var convertview: View? = convertview

        if (convertview == null) {
            val inflater =
                _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertview = inflater.inflate(
                R.layout.item_recipe_detail_list_expandable_item,
                parentview,
                false
            )

        }

        val childTextvew = convertview?.findViewById(R.id.expandedListItem) as TextView
        Log.d("debago", "getchil is " + getChild(parent, child))
        childTextvew.text = getChild(parent, child) as String


        return convertview
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

}