package safcsp.android.usenatesinfo.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*
import safcsp.android.usenatesinfo.R
import safcsp.android.usenatesinfo.senatesdata.Object
import safcsp.android.usenatesinfo.senatesdata.Person

class SenatorListFragment : Fragment() {

    interface Callbacks {
        fun onSenatorSelected(id: Int)
    }

    private var callbacks: Callbacks? = null

    private lateinit var senatesRecyclerView: RecyclerView
    private lateinit var adapter: SenatorAdapter
    private lateinit var person: Person


    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_senator_list, container, false)

        val person = mutableListOf<Person>()
        val adapter = SenatorAdapter(requireContext(), person)

        senatesRecyclerView = view.findViewById(R.id.senator_recycler_view) as RecyclerView
        senatesRecyclerView.layoutManager = LinearLayoutManager(context)
        senatesRecyclerView.adapter = adapter

        return view
    }


    private inner class SenateHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        override fun onClick(v: View?) {
            callbacks?.onSenatorSelected(person.cspanid)
        }

    }

    private inner class SenatorAdapter(
        val context: Context,
        val person: List<Person>
    ) :

        RecyclerView.Adapter<SenatorAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
            )
        }

        override fun getItemCount() = person.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val objectSenate = person.cspanid[position]
            holder.bind(objectSenate)
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(objectSenate: Object) {
                itemView.tvSenatorName.text = objectSenate.person.firstname
                itemView.tvDescription.text = objectSenate.description
                itemView.tvParty.text = objectSenate.party

            }
        }
    }
}