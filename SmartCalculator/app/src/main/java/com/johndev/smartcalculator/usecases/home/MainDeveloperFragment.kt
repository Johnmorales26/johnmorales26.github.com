package com.johndev.smartcalculator.usecases.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentMainDeveloperBinding
import com.vansuita.materialabout.builder.AboutBuilder

class MainDeveloperFragment : Fragment() {

    private var _binding: FragmentMainDeveloperBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainDeveloperBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val builder: AboutBuilder = AboutBuilder.with(requireActivity())
            .setAppIcon(com.johndev.smartcalculator.R.mipmap.ic_launcher)
            .setAppName(com.johndev.smartcalculator.R.string.app_name)
            .setPhoto(R.drawable.john_morales)
            .setCover(com.johndev.smartcalculator.R.mipmap.profile_cover)
            .setLinksAnimated(true)
            .setDividerDashGap(13)
            .setName(getString(R.string.main_developer_name))
            .setSubTitle(getString(R.string.main_developer_dev))
            .setLinksColumnsCount(4)
            .setBrief(getString(R.string.main_developer_description))
            //.addGooglePlayStoreLink("5866365364411416385")
            .addGitHubLink("Johnmorales26")
            //.addBitbucketLink("jrvansuita")
            .addFacebookLink("jonh.mt.54")
            .addTwitterLink("JohnMor65705263")
            .addInstagramLink("johnmorales_sw")
            //.addGooglePlusLink("+JuniorVansuita")
            //.addYoutubeChannelLink("CaseyNeistat")
            //.addDribbbleLink("user")
            .addLinkedInLink("jonatan-arturo-morales-tavera-0ba5b1217")
            .addEmailLink("johnta2610@hotmail.com")
            //.addWhatsAppDirectChat("5520250858") //.
            .addWhatsappLink("John Developer", "+525520250858")
            //.addSkypeLink("user")
            //.addGoogleLink("user")
            //.addAndroidLink("user")
            //.addWebsiteLink("site")
            .addFiveStarsAction()
            .addMoreFromMeAction("Jonatan+Morales")
            .setVersionNameAsAppSubTitle()
            .addShareAction(com.johndev.smartcalculator.R.string.app_name)
            .addUpdateAction()
            .setActionsColumnsCount(2)
            .addFeedbackAction("vansuita.jr@gmail.com")
            .addPrivacyPolicyAction("http://www.docracy.com/2d0kis6uc2")
            //.addIntroduceAction(null as Intent?)
            //.addHelpAction(null as Intent?)
            //.addChangeLogAction(null as Intent?)
            //.addRemoveAdsAction(null as Intent?)
            //.addDonateAction(null as Intent?)
            .setWrapScrollView(true)
            .setShowAsCard(true)

        val view = builder.build()

        binding.aboutView.addView(view)

    }

}