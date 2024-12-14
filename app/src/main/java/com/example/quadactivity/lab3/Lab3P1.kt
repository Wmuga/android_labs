package com.example.quadactivity.lab3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quadactivity.R
import com.example.quadactivity.databinding.ActivityLab3P1Binding

data class PersonInfo(val name:String, val picUrl:String)


class Lab3P1 : AppCompatActivity() {
    private lateinit var binding: ActivityLab3P1Binding
    private var expected = ""
    private var toCheck = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLab3P1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setImage()
        binding.buttonPersonAnswer.setOnClickListener{btn()}
    }

    private fun btn(){
        if (toCheck){
            binding.buttonPersonAnswer.text = resources.getString(R.string.next)
            check()
            toCheck = false
            return
        }
        binding.buttonPersonAnswer.text = resources.getString(R.string.check)
        toCheck = true
        setImage()
    }

    private fun check(){
        val answer = binding.editPersonName.text.toString().lowercase()
        if (expected.contains(answer)){
            binding.textPersonResult.text = resources.getString(R.string.testOK)
            binding.textPersonResult.setTextColor(getColor(R.color.green))
            return
        }
        binding.textPersonResult.text = resources.getString(R.string.testWrong)
        binding.textPersonResult.setTextColor(getColor(R.color.red ))
    }

    private fun setImage(){
        binding.textPersonResult.text = ""
        binding.editPersonName.setText("")
        val idx = (Math.random()*persons.size).toInt()
        val person = persons[idx]
        expected = person.name.lowercase()
        binding.editPersonName.hint = person.name
        val task = DownloadImageTask(binding.personImage)
        task.execute(person.picUrl)
        binding
    }

    private val persons = arrayOf(
        PersonInfo("Хабиб Нурмагомедов","https://cdn.forbes.ru/files/c/72x48/profile/rian_5661305.mr_.ru_.jpg_1563379829_52746_vid380127e.jpg__1563981890__64769.webp"),
        PersonInfo("Ольга Бузова","https://cdn.forbes.ru/files/c/72x48/profile/02_uso_lm_01810.jpg_1563360057_88005_vid380119e.jpg__1563370135__64969.webp"),
        PersonInfo("Егор Крид (Егор Булаткин)","https://cdn.forbes.ru/files/c/72x48/profile/04_kmo_165544_00467_1.jpg_1563360115_27590_vid380119e.jpg__1563370257__81039.webp"),
        PersonInfo("Александр Овечкин","https://cdn.forbes.ru/files/c/72x48/profile/49684.jpg_1563293440_14848_vid380109e.jpg__1563370199__32948.webp"),
        PersonInfo("Ксения Собчак","https://cdn.forbes.ru/files/c/76x48/profile/20_sobchak.jpg__1593069009__90629.webp"),
        PersonInfo("Тимати","https://cdn.forbes.ru/files/c/72x48/profile/tass_33905883.jpg_1563292526_45942_vid380107e.jpg__1563370433__45174.webp"),
        PersonInfo("Дима Билан","https://cdn.forbes.ru/files/c/81x48/forbes_import/13/13-2704_0.webp"),
        PersonInfo("Полина Гагарина","https://cdn.forbes.ru/files/c/76x48/profile/20_polina_gagarina.jpg__1593068984__46058.webp"),
        PersonInfo("Артемий Панарин","https://cdn.forbes.ru/files/c/72x48/profile/artemii_panarin_nhl.jpg__1586970740__95621.webp"),
        PersonInfo("Баста (Василий Вакуленко)","https://cdn.forbes.ru/files/c/72x48/profile/53187.jpg_1563292377_86425_vid380107e.jpg__1563370311__52319.webp"),
        PersonInfo("Сергей Лазарев","https://cdn.forbes.ru/files/c/72x48/profile/17_tass_30367823.jpg_1563360587_37396_vid380119e.jpg__1563370968__14310.webp"),
        PersonInfo("Даниил Медведев","https://cdn.forbes.ru/files/c/68x48/profile/tass_36183369.jpg__1586970655__42629.webp"),
        PersonInfo("Артем Дзюба","https://cdn.forbes.ru/files/c/72x48/profile/1-tass_27410404.jpg__1532499923__72182.webp"),
        PersonInfo("Евгений Малкин","https://cdn.forbes.ru/files/c/81x48/forbes_import/ta/tass_3619587.webp"),
        PersonInfo("Юлия Зиверт (Zivert)","https://cdn.forbes.ru/files/c/72x48/profile/8.jpg__1587239440__31368.webp"),
        PersonInfo("Ирина Шейк","https://cdn.forbes.ru/files/c/65x48/profile/snimok_ekrana_2019-07-17_v_16.36.34.png__1563370663__52979.webp"),
        PersonInfo("Настя Ивлеева","https://cdn.forbes.ru/files/c/72x48/profile/forbes10-28340.jpg_1563379888_84042_vid380127e.jpg__1563982742__40950.webp"),
        PersonInfo("Little Big (Илья Прусикин)","https://cdn.forbes.ru/files/c/76x48/profile/litlbig.jpg__1563368738__46270.webp"),
        PersonInfo("Юрий Дудь","https://cdn.forbes.ru/files/c/72x48/profile/2-tass_24338150.jpg__1532501261__87849.webp"),
        PersonInfo("Гарик Харламов","https://cdn.forbes.ru/files/c/72x48/profile/harlamov.jpg__1563366135__70354.webp"),
        PersonInfo("Алишер Моргенштерн (Morgenshtern)","https://cdn.forbes.ru/files/c/73x48/profile/morgenshtein_inst.jpg__1586984691__49220.webp"),
        PersonInfo("Сергей Ковалев","https://cdn.forbes.ru/files/c/81x48/forbes_import/06/06-tass_12008010_0.webp"),
        PersonInfo("Карен Хачанов","https://cdn.forbes.ru/files/c/72x48/profile/20_gettyimages-1153537809.jpg_1563358138_87821_vid380109e.jpg__1563981218__87281.webp"),
        PersonInfo("Wylsacom","https://cdn.forbes.ru/files/c/76x48/profile/vilsa.png__1563364642__67254.webp"),
        PersonInfo("Мария Шарапова","https://cdn.forbes.ru/files/c/72x48/profile/rtx6ofz1.jpg_1563357991_59119_vid380109e.jpg__1563370828__22517.webp"),
        PersonInfo("Элджей (Алексей Узенюк)","https://cdn.forbes.ru/files/c/48x46/profile/snimok_ekrana_2019-07-17_v_14.44.49.png__1563363925__63285.webp"),
        PersonInfo("Семен Слепаков","https://cdn.forbes.ru/files/c/72x48/profile/28_4527336.jpg_1563359533_75870_vid380117e.jpg__1563371096__40317.webp"),
        PersonInfo("Федор Смолов","https://cdn.forbes.ru/files/c/72x48/profile/3-tass_27751474.jpg__1532500626__21742.webp"),
        PersonInfo("Эмин Агаларов","https://cdn.forbes.ru/files/c/76x48/profile/agalarovy_forbes_malikov127286.jpg__1563365710__37649.webp"),
        PersonInfo("Михаил Галустян","https://cdn.forbes.ru/files/c/72x48/profile/22_rian_5695951.hr_.ru_.jpg_1563359438_16010_vid380117e.jpg__1563371036__29037.webp"),
        PersonInfo("Алина Загитова","https://cdn.forbes.ru/files/c/48x48/profile/zagitova.jpg__1553866415__45917.webp"),
        PersonInfo("Александр Головин","https://cdn.forbes.ru/files/c/48x48/profile/golovin.jpg__1553867948__38661.webp"),
        PersonInfo("Александр Петров","https://cdn.forbes.ru/files/c/72x48/profile/petrov.jpg__1563368293__14310.webp"),
        PersonInfo("Мот","https://cdn.forbes.ru/files/c/72x48/profile/mot.jpg__1563366812__45023.webp"),
        PersonInfo("Данила Козловский","https://cdn.forbes.ru/files/c/81x48/forbes_import/6-/6-md_ok_danila_589_lr_0_0.webp"),
        PersonInfo("Наталья Водянова","https://cdn.forbes.ru/files/c/72x48/profile/32_vodyanova_01.jpg_1563361190_70696_vid380119e.jpg__1563371222__76854.webp"),
        )
}