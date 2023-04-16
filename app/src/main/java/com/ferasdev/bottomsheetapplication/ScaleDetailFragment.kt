package com.ferasdev.bottomsheetapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ferasdev.bottomsheetapplication.databinding.FragmentScaleDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ScaleDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScaleDetailFragment : Fragment() {

    private lateinit var binding: FragmentScaleDetailBinding
    private lateinit var scaleDialog: BottomSheetDialog
    private lateinit var scaleItemAdapter: ScaleItemAdapter
    private val scaleList = ArrayList<ScaleItem>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var content:String

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentScaleDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        content = "Quisque pretium arcu a dolor aliquam sollicitudin. " +
                "Integer eget lorem venenatis, imperdiet nunc sed, placerat lectus. " +
                "Pellentesque laoreet a nibh a ultrices. " +
                "Duis laoreet, orci ac convallis feugiat, " +
                "ante sem blandit sem, eget pellentesque mauris mi a erat. " +
                "Phasellus quis nisi sodales, fermentum neque sed, mattis ante. " +
                "Mauris vehicula elit eu erat semper viverra non in urna. " +
                "Nunc sem eros, euismod pharetra molestie et, lacinia in lacus.\n" +
                "Quisque suscipit justo ac ligula porta, vel ullamcorper odio ullamcorper. " +
                "Morbi pretium tellus ultrices leo tincidunt, quis aliquam mauris feugiat. " +
                "In erat leo, dapibus non neque sed, fermentum pharetra nibh. " +
                "Morbi sit amet volutpat diam, ac rhoncus tortor. " +
                "Fusce at arcu vehicula, commodo felis ac, volutpat nibh. " +
                "Nam viverra fermentum libero nec pellentesque. In hac habitasse platea dictumst."

        for (i in 1..10) {
            scaleList.add(ScaleItem("Item $i",R.drawable.ic_arrow_down, content))
        }

        binding.tvSelectItemFragmentScaleDetail.setOnClickListener {
            showScaleBottomSheet()

        }



        return view
        //inflater.inflate(R.layout.fragment_scale_detail, container, false)
    }

    private fun showScaleBottomSheet() {
        val dialogView = layoutInflater.inflate(R.layout.scale_bottom_sheet, null)
        scaleDialog = BottomSheetDialog(requireContext()) // R.style.ScaleBottomSheetDialogThem
        scaleDialog.setContentView(dialogView)
        recyclerView = dialogView.findViewById(R.id.rv_item_scale_bottom_sheet)
        scaleItemAdapter = ScaleItemAdapter(scaleList)
        recyclerView.adapter = scaleItemAdapter
        scaleDialog.show()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ScaleDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ScaleDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}