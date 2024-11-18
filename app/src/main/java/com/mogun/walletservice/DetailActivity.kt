package com.mogun.walletservice

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.icu.util.Calendar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.mogun.walletservice.databinding.ActivityDetailBinding
import com.mogun.walletservice.model.DetailItem
import com.mogun.walletservice.model.Type
import java.time.Year

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val adapter = DetailListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this

        initView()

        adapter.submitList(mockData())
    }

    private fun initView() {
        binding.cardTitleTextView.text = intent.getStringExtra(CARD_NAME)
        binding.cardLayout.backgroundTintList =
            intent.getParcelableExtra(CARD_COLOR) as? ColorStateList
        binding.recyclerView.adapter = adapter
    }

    private fun mockData(): List<DetailItem> {
        fun createDate(year: Int, month: Int, day: Int) = Calendar.getInstance().apply {
            set(year, month, day)
        }.time

        val list = mutableListOf<DetailItem>().apply {
            add(
                DetailItem(
                    1,
                    createDate(2024, 11, 11),
                    "A상점",
                    24000,
                    Type.PAY
                )
            )
            add(
                DetailItem(
                    2,
                    createDate(2024, 11, 4),
                    "B상점",
                    48000,
                    Type.PAY
                )
            )
            add(
                DetailItem(
                    3,
                    createDate(2024, 11, 1),
                    "C상점",
                    148000,
                    Type.PAY
                )
            )
            add(
                DetailItem(
                    4,
                    createDate(2024, 10, 28),
                    "D상점",
                    19000,
                    Type.CANCEL,
                )
            )
            add(
                DetailItem(
                    5,
                    createDate(2024, 10, 28),
                    "D상점",
                    19000,
                    Type.PAY,
                )
            )
            add(
                DetailItem(
                    6,
                    createDate(2024, 10, 24),
                    "룰루상점",
                    148000,
                    Type.POINT
                )
            )
            add(
                DetailItem(
                    7,
                    createDate(2024, 10, 21),
                    "C상점",
                    1148000,
                    Type.PAY
                )
            )
            add(
                DetailItem(
                    8,
                    createDate(2024, 10, 15),
                    "갈가리상점",
                    1148000,
                    Type.CANCEL
                )
            )
            add(
                DetailItem(
                    9,
                    createDate(2024, 10, 15),
                    "갈가리상점",
                    1148000,
                    Type.PAY
                )
            )
            add(
                DetailItem(
                    10,
                    createDate(2024, 10, 8),
                    "음식점",
                    1148000,
                    Type.PAY
                )
            )
        }

        return list
    }

    companion object {
        private const val CARD_NAME = "CARD_NAME"
        private const val CARD_COLOR = "CARD_COLOR"

        fun start(
            context: Context,
            cardName: String,
            cardColor: ColorStateList?,
            optionsCompat: ActivityOptionsCompat
        ) {
            Intent(context, DetailActivity::class.java).apply {
                putExtra(CARD_NAME, cardName)
                putExtra(CARD_COLOR, cardColor)
            }.run {
                context.startActivity(this, optionsCompat.toBundle())
            }
        }
    }
}