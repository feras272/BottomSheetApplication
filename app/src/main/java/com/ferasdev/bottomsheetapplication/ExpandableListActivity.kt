package com.ferasdev.bottomsheetapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.navigation.ui.AppBarConfiguration
import com.ferasdev.bottomsheetapplication.ExpandableListData.ExpandableListData.data
import com.ferasdev.bottomsheetapplication.databinding.ActivityExpandableListBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class ExpandableListActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityExpandableListBinding

    // Expandable List View
    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var titleList: List<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpandableListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_expandable_list)

        BottomSheetBehavior.from(binding.flBottomSheetActivityExpandableList).apply {
            peekHeight = 200 // before swipe above
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        title = "KotlinApp"
        expandableListView = findViewById(R.id.expendableList)
        if (expandableListView != null) {
            val listData = data
            titleList = ArrayList(listData.keys)
            adapter = CustomExpandableListAdapter(this, titleList as ArrayList<String>, listData)
            expandableListView!!.setAdapter(adapter)
            expandableListView!!.setOnGroupExpandListener { groupPosition ->
                Toast.makeText(
                    applicationContext,
                    (titleList as ArrayList<String>)[groupPosition] + " List Expanded.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            expandableListView!!.setOnGroupCollapseListener { groupPosition ->
                Toast.makeText(
                    applicationContext,
                    (titleList as ArrayList<String>)[groupPosition] + " List Collapsed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            expandableListView!!.setOnChildClickListener { _, _, groupPosition, childPosition, _ ->
                Toast.makeText(
                    applicationContext,
                    "Clicked: " + (titleList as ArrayList<String>)[groupPosition] + " -> " + listData[(
                            titleList as
                                    ArrayList<String>
                            )
                            [groupPosition]]!!.get(
                        childPosition
                    ),
                    Toast.LENGTH_SHORT
                ).show()
                false
            }
        }

    }
}