package com.andersonk.androidcourse.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.andersonk.androidcourse.R
import com.andersonk.androidcourse.adapter.QuestionAdapter
import com.andersonk.androidcourse.models.QuestionList
import com.andersonk.androidcourse.services.Api
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.stack_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class StackFragment : Fragment() {

    lateinit var questionAdapter: QuestionAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.stack_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionAdapter = QuestionAdapter()
        val layoutManager = LinearLayoutManager(activity)
        recycler_questions.layoutManager = layoutManager
        recycler_questions.adapter = questionAdapter
        getData()
    }


    private fun getData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.stackexchange.com/2.2/")
            .addConverterFactory(JacksonConverterFactory.create()).build()
        val service = retrofit.create<Api>(Api::class.java)

        val call = service.getQuestions(
            mapOf(
                "order" to "desc",
                "sort" to "activity",
                "site" to "stackoverflow"
            )
        )
        //lista de requisicoes ficam na fila  todas chamadas sao encadeadas
        call.enqueue(object : Callback<QuestionList> {
            override fun onFailure(call: Call<QuestionList>, t: Throwable) {
                Log.d("Error", t.toString())
            }

            override fun onResponse(call: Call<QuestionList>, response: Response<QuestionList>) {
                when (response.code()) {
                    200 -> {
                        val body = response.body()
                        body?.let {
                            questionAdapter.setQuestions(it.items)
                        }
                        Log.d("NETWORK", response.body().toString())
                    }
                    204 -> Log.d("NETWORK", "Not content")

                }
            }

        })


    }
}