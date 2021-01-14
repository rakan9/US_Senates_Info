package safcsp.android.usenatesinfo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import safcsp.android.usenatesinfo.R
import safcsp.android.usenatesinfo.senatesdata.Person

private const val PERSON_ID = "person_id"

class SenatorFragment: Fragment() {

    private lateinit var person: Person
    private lateinit var address: TextView
    private lateinit var office: TextView
    private lateinit var birthDay: TextView
    private lateinit var endDate: TextView
    private lateinit var gender: TextView
    private lateinit var sortname: TextView
    private lateinit var website: TextView


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val senatorId: Int = arguments?.getSerializable(PERSON_ID) as Int

        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_senator, container, false)

            address = view.findViewById(R.id.address)
            office = view.findViewById(R.id.office)
            birthDay = view.findViewById(R.id.birthday)
            endDate = view.findViewById(R.id.end_date)
            gender = view.findViewById(R.id.gender)
            sortname = view.findViewById(R.id.sortname)
            website = view.findViewById(R.id.website)

            return view
        }


        companion object {

            fun newInstance(senatorId: Int): SenatorFragment {
                val args = Bundle().apply {
                    putSerializable(PERSON_ID, senatorId)
                }
                return SenatorFragment().apply {
                    arguments = args
                }
            }
        }
    }


