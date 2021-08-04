package ru.tregubowww.andersen_home_work_5

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ContactsFragment : Fragment() {

    private var listener: TransactionsContactsFragmentClicks? = null

    private lateinit var contactView1: ContactView
    private lateinit var contactView2: ContactView
    private lateinit var contactView3: ContactView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initContacts(view)
        setOnClickListeners()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is TransactionsContactsFragmentClicks) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private fun setOnClickListeners() {

        contactView1.setOnClickListener {
            listener?.onContactClick(ContactsDB.contact1)
        }
        contactView2.setOnClickListener {
            listener?.onContactClick(ContactsDB.contact2)
        }
        contactView3.setOnClickListener {
            listener?.onContactClick(ContactsDB.contact3)
        }
    }

    private fun initContacts(view: View) {
        contactView1 = view.findViewById(R.id.contact1)
        contactView2 = view.findViewById(R.id.contact2)
        contactView3 = view.findViewById(R.id.contact3)

        contactView1.apply {
            phoneNumber = (ContactsDB.contact1.phoneNumber)
            name = (ContactsDB.contact1.name)
        }

        contactView2.apply {
            phoneNumber = (ContactsDB.contact2.phoneNumber)
            name = (ContactsDB.contact2.name)
        }

        contactView3.apply {
            phoneNumber = (ContactsDB.contact3.phoneNumber)
            name = (ContactsDB.contact3.name)
        }
    }

    companion object {
        fun newInstance() = ContactsFragment()
    }

    interface TransactionsContactsFragmentClicks {
        fun onContactClick(contact: Contact)
    }
}