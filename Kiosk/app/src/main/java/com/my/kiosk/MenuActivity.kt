package com.my.kiosk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.my.kiosk.layout.MenuBoard

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val menuEntityDataClass = mutableListOf<MenuEntityDataClass>()
        val _menuEntityDataClassNames = listOf<String>(
            "콜드브루",
            "브루드",
            "에스프레소",
            "프라푸치노",
            "블렌디드",
            "스타벅스 리프레셔",
            "스타벅스 피지오",
            "티(티바나)",
            "기타 제조 음료",
            "스타벅스 주스(병음료)"
        )

        _menuEntityDataClassNames.forEachIndexed{ i, item ->
            menuEntityDataClass.add(
                MenuEntityDataClass(
                    item,
                    i
                )
            )
        }

        setContent {
            val menuEntityList: MutableState<List<MutableList<MutableState<Beverage>>>> = remember { mutableStateOf(
                List<MutableList<MutableState<Beverage>>>(_menuEntityDataClassNames.size) {
                    when(it) {
                        0 ->
                            mutableListOf<MutableState<Beverage>>(
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2024/04/[9200000004544]_20240423124241716.jpg",
                                    name= "씨솔트 카라멜 콜드 브루",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4506 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002487]_20210426091745467.jpg",
                                    name= "나이트로 바닐라 크림",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7462 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000479]_20210426091843897.jpg",
                                    name= "나이트로 콜드 브루",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7017 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002081]_20210415133656839.jpg",
                                    name= "돌체 콜드 브루",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5202 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/02/[9200000002407]_20210225095106743.jpg",
                                    name= "리저브 나이트로",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9231 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2024/03/[9200000002093]_20240318144604476.jpg",
                                    name= "리저브 콜드 브루",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7173 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2022/10/[9200000004312]_20221005145029134.jpg",
                                    name= "민트 콜드 브루",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5836 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000487]_20210430112319040.jpg",
                                    name= "바닐라 크림 콜드 브루",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8382 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000003661]_20230721170207026.jpg",
                                    name= "시그니처 더 블랙 콜드 브루",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7059 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/08/[9200000004750]_20230801101408624.jpg",
                                    name= "여수 윤슬 헤이즐넛 콜드브루",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9754 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000003285]_20210416154437069.jpg",
                                    name= "오트 콜드 브루",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4717 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2022/03/[9200000002672]_20220311105511600.jpg",
                                    name= "제주 비자림 콜드 브루",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4332 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000038]_20210430113202458.jpg",
                                    name= "콜드 브루",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5853 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004770]_20230720103902092.jpg",
                                    name= "콜드 브루",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8532 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/02/[9200000001636]_20210225093600536.jpg",
                                    name= "콜드 브루 몰트",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8695 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/02/[9200000001636]_20210225093600536.jpg",
                                    name= "콜드 브루 몰트",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8582 )),
                            )
                        1 ->
                            mutableListOf<MutableState<Beverage>>(
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[1],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[106509]_20210430111852870.jpg",
                                    name= "아이스 커피",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9117 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[1],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[2]_20210430111934117.jpg",
                                    name= "오늘의 커피",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4455 )),
                            )
                        2 ->
                            mutableListOf<MutableState<Beverage>>(
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2024/03/[9200000005181]_20240326103832835.jpg",
                                    name= "아이스 플랫 화이트",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7020 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2024/03/[9200000005178]_20240326103727795.jpg",
                                    name= "플랫 화이트",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5474 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[30]_20210415144252244.jpg",
                                    name= "에스프레소 콘 파나",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7795 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[25]_20210415144211211.jpg",
                                    name= "에스프레소 마키아또",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5830 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110563]_20210426095937808.jpg",
                                    name= "아이스 카페 아메리카노",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5116 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[94]_20210430103337006.jpg",
                                    name= "카페 아메리카노",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8461 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110582]_20210415142706078.jpg",
                                    name= "아이스 카라멜 마키아또",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4636 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[126197]_20210415154609863.jpg",
                                    name= "카라멜 마키아또",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5896 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110601]_20210415143400773.jpg",
                                    name= "아이스 카푸치노",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9911 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[38]_20210415154821846.jpg",
                                    name= "카푸치노",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4667 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[9200000004119]_20220412083025862.png",
                                    name= "라벤더 카페 브레베",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4268 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/02/[9200000001939]_20210225094313315.jpg",
                                    name= "바닐라 빈 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6113 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2024/03/[9200000002095]_20240318144701881.jpg",
                                    name= "사케라또 비안코 오버 아이스",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6442 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004732]_20230705095514946.jpg",
                                    name= "스타벅스 1호점 바닐라 빈 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8604 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004728]_20230705095319596.jpg",
                                    name= "스타벅스 1호점 카페 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7204 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[128692]_20210426091933665.jpg",
                                    name= "스타벅스 돌체 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7621 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[9200000004120]_20220412082952150.png",
                                    name= "아이스 라벤더 카페 브레베",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7335 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/02/[9200000001941]_20210225094346653.jpg",
                                    name= "아이스 바닐라 빈 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5141 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004734]_20230705095557184.jpg",
                                    name= "아이스 스타벅스 1호점 바닐라 빈 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4006 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004730]_20230705095423060.jpg",
                                    name= "아이스 스타벅스 1호점 카페 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9993 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[128695]_20210426092031969.jpg",
                                    name= "아이스 스타벅스 돌체 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5664 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110569]_20210415143035989.jpg",
                                    name= "아이스 카페 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8908 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[41]_20210415133833725.jpg",
                                    name= "카페 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5687 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110566]_20210415134334280.jpg",
                                    name= "아이스 카페 모카",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8792 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110572]_20210415155545375.jpg",
                                    name= "아이스 화이트 초콜릿 모카",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4414 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[46]_20210415134438165.jpg",
                                    name= "카페 모카",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6585 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2022/10/[9200000004313]_20221005145156959.jpg",
                                    name= "클래식 민트 모카",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6149 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[128192]_20210415155639126.jpg",
                                    name= "화이트 초콜릿 모카",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9919 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110612]_20210415133425373.jpg",
                                    name= "바닐라 스타벅스 더블 샷",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8053 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002950]_20210426150654756.jpg",
                                    name= "블론드 바닐라 더블 샷 마키아또",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6699 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/03/[9200000003505]_20210322093241535.jpg",
                                    name= "사케라또 아포가토",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9446 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/03/[9200000003506]_20210322093317854.jpg",
                                    name= "스파클링 시트러스 에스프레소",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6033 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002953]_20210427132718157.jpg",
                                    name= "아이스 블론드 바닐라 더블 샷 마키아또",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4675 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[20]_20210415144112678.jpg",
                                    name= "에스프레소",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5099 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110611]_20210415132507539.jpg",
                                    name= "커피 스타벅스 더블 샷",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8883 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/02/[9200000001631]_20210225090916684.jpg",
                                    name= "클래식 아포가토",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7923 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[2],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110614]_20210415132333109.jpg",
                                    name= "헤이즐넛 스타벅스 더블 샷",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9049 )),
                            )
                        3 ->
                            mutableListOf<MutableState<Beverage>>(
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[3],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[168007]_20210415144337428.jpg",
                                    name= "에스프레소 프라푸치노",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8958 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[3],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[168016]_20210415154152122.jpg",
                                    name= "자바 칩 프라푸치노",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8478 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[3],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[168010]_20210415154711116.jpg",
                                    name= "카라멜 프라푸치노",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7447 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[3],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[168013]_20210415155746379.jpg",
                                    name= "화이트 초콜릿 모카 프라푸치노",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5824 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[3],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2020/09/[9200000002088]_20200921171733532.jpg",
                                    name= "제주 까망 크림 프라푸치노",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6582 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[3],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002502]_20210426100408048.jpg",
                                    name= "제주 말차 크림 프라푸치노",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8331 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[3],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2022/03/[9200000002090]_20220329144732789.jpg",
                                    name= "제주 쑥떡 크림 프라푸치노",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9939 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[3],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[168066]_20210415154429750.jpg",
                                    name= "초콜릿 크림 칩 프라푸치노",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6139 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[3],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002403]_20210419131548656.jpg",
                                    name= "화이트 타이거 프라푸치노",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4481 )),
                            )
                        4 ->
                            mutableListOf<MutableState<Beverage>>(
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[4],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2024/04/[9200000005171]_20240424090244816.jpg",
                                    name= "더블 레몬 블렌디드",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4944 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[4],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2024/04/[9200000005165]_20240423124402730.jpg",
                                    name= "스타벅스 클래식 밀크 티 블렌디드",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9504 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[4],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/02/[9200000004512]_20230207150514347.jpg",
                                    name= "망고 패션 티 블렌디드",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8695 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[4],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/11/[9200000004716]_20231115093249233.jpg",
                                    name= "북한산 레몬 얼 그레이 블렌디드",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5687 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[4],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/12/[9200000004945]_20231205083518102.jpg",
                                    name= "스타벅스 클래식 밀크티 블렌디드",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5561 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[4],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/09/[9200000004870]_20230905110300360.jpg",
                                    name= "여수 바다 유자 블렌디드",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8991 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[4],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000003276]_20210416154001403.jpg",
                                    name= "딸기 딜라이트 요거트 블렌디드",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9652 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[4],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[169001]_20210419130701792.jpg",
                                    name= "망고 바나나 블렌디드",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4762 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[4],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/09/[9200000004871]_20230922091835355.jpg",
                                    name= "코튼 스카이 요거트 블렌디드",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6495 )),
                            )
                        5 ->
                            mutableListOf<MutableState<Beverage>>(
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[5],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004753]_20230720103623021.jpg",
                                    name= "딸기 아사이 레모네이드 스타벅스 리프레셔",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8558 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[5],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2022/08/[9200000003763]_20220803131322551.jpg",
                                    name= "딸기 아사이 레모네이드 스타벅스 리프레셔",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4560 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[5],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004439]_20230710134159744.jpg",
                                    name= "망고 용과 레모네이드 스타벅스 리프레셔",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9433 )),
                            )
                        6 ->
                            mutableListOf<MutableState<Beverage>>(
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[6],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2024/04/[9200000005168]_20240430164715738.jpg",
                                    name= "라이트 핑크 자몽 피지오",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8271 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[6],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/10/[9200000004949]_20231005084714271.jpg",
                                    name= "레드 애플 피지오",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4809 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[6],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2024/01/[9200000004948]_20240103144748363.jpg",
                                    name= "아이스크림 레드 애플 피지오",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7703 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[6],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/09/[9200000004751]_20230907153225204.jpg",
                                    name= "여수 바다 자몽 피지오",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5456 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[6],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2022/05/[9200000004121]_20220517102911610.jpg",
                                    name= "유자 패션 피지오",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6768 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[6],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2024/01/[9200000004946]_20240103144959834.jpg",
                                    name= "제주팔삭 셔벗 피지오",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7151 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[6],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/10/[9200000004947]_20231005084610514.jpg",
                                    name= "제주팔삭 피지오",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7084 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[6],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[107051]_20210419112151972.jpg",
                                    name= "쿨 라임 피지오",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8082 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[6],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/05/[9200000004567]_20230524144959475.jpg",
                                    name= "피치 딸기 피지오",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8218 )),
                            )
                        7 ->
                            mutableListOf<MutableState<Beverage>>(
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000056]_20210415135215632.jpg",
                                    name= "민트 블렌드 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5212 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000059]_20210415141656038.jpg",
                                    name= "아이스 민트 블렌드 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6353 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000039]_20210415142055860.jpg",
                                    name= "아이스 얼 그레이 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4752 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000229]_20210415142219481.jpg",
                                    name= "아이스 유스베리 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5828 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[9200000002959]_20220411155904911.jpg",
                                    name= "아이스 유자 민트 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6015 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000019]_20210415142323353.jpg",
                                    name= "아이스 잉글리쉬 브렉퍼스트 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6385 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[400400000094]_20210415230316469.jpg",
                                    name= "아이스 제주 유기농 녹차로 만든 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9597 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/10/[9200000004944]_20231005084446254.jpg",
                                    name= "아이스 제주팔삭 &amp; 자몽 허니 블랙 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6088 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000079]_20210415143641139.jpg",
                                    name= "아이스 캐모마일 블렌드 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7431 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000069]_20210415143811231.jpg",
                                    name= "아이스 히비스커스 블렌드 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5296 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000036]_20210415143933425.jpg",
                                    name= "얼 그레이 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6830 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000226]_20210415144434521.jpg",
                                    name= "유스베리 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7947 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[9200000002956]_20220411155551915.jpg",
                                    name= "유자 민트 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8381 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000016]_20210415153648533.jpg",
                                    name= "잉글리쉬 브렉퍼스트 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8701 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000187]_20210419131229539.jpg",
                                    name= "자몽 허니 블랙 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9082 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[400400000091]_20210415132229904.jpg",
                                    name= "제주 유기농 녹차로 만든 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4666 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/10/[9200000004943]_20231005084424843.jpg",
                                    name= "제주팔삭 &amp; 자몽 허니 블랙 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7506 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000076]_20210415154920731.jpg",
                                    name= "캐모마일 블렌드 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7300 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000066]_20210415155836395.jpg",
                                    name= "히비스커스 블렌드 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4110 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/04/[9200000004566]_20230407153247174.jpg",
                                    name= "레드 파워 패션 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6518 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/12/[9200000004990]_20231212110704134.jpg",
                                    name= "레몬 캐모마일 블렌드 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5102 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/12/[9200000004991]_20231212110749533.jpg",
                                    name= "아이스 레몬 캐모마일 블렌드 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4477 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000190]_20210419131723532.jpg",
                                    name= "아이스 자몽 허니 블랙 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8586 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004769]_20230720103743478.jpg",
                                    name= "아이스 자몽 허니 블랙 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6110 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/11/[9200000004954]_20231127093740735.jpg",
                                    name= "말차 티라미수 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8751 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/12/[9200000004988]_20231212110855121.jpg",
                                    name= "스노우 말차 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4682 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/09/[9200000004933]_20230914141717984.jpg",
                                    name= "스타벅스 클래식 밀크 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6077 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/10/[9200000004942]_20231005093131816.jpg",
                                    name= "스타벅스 클래식 밀크 티 보틀",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4066 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/11/[9200000004955]_20231127093837610.jpg",
                                    name= "아이스 말차 티라미수 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4879 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/12/[9200000004989]_20231212110950941.jpg",
                                    name= "아이스 스노우 말차 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8669 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/09/[9200000004936]_20230914141811407.jpg",
                                    name= "아이스 스타벅스 클래식 밀크 티",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5423 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/01/[9200000004288]_20230118085139616.jpg",
                                    name= "아이스 얼 그레이 바닐라 티 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5154 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002499]_20210419130902541.jpg",
                                    name= "아이스 제주 말차 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5594 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[135612]_20210415142512793.jpg",
                                    name= "아이스 차이 티 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9129 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/01/[9200000004285]_20230118084943128.jpg",
                                    name= "얼 그레이 바닐라 티 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7749 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002496]_20210419131039350.jpg",
                                    name= "제주 말차 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7263 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[7],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[135608]_20210415154244810.jpg",
                                    name= "차이 티 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4569 )),
                            )
                        8 ->
                            mutableListOf<MutableState<Beverage>>(
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[8],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2024/04/[9200000004939]_20240430143115844.jpg",
                                    name= "스타벅스 딸기 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9395 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[8],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/12/[9200000004950]_20231204090636952.jpg",
                                    name= "딸기 콜드폼 초콜릿",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7897 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[8],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[72]_20210415140949967.jpg",
                                    name= "시그니처 핫 초콜릿",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6860 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[8],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110621]_20210415140901611.jpg",
                                    name= "아이스 시그니처 초콜릿",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4469 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[8],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/11/[9200000004953]_20231127094019543.jpg",
                                    name= "아이스 티라미수 초콜릿",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8420 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[8],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/11/[9200000004952]_20231127093937845.jpg",
                                    name= "티라미수 초콜릿",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8743 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[8],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000003658]_20210422080248176.jpg",
                                    name= "플러피 판다 아이스 초콜릿",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8900 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[8],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002594]_20210422080327783.jpg",
                                    name= "플러피 판다 핫 초콜릿",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4547 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[8],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/11/[9200000004951]_20231102101647442.jpg",
                                    name= "딸기 콜드폼 딸기 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4417 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[8],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000003659]_20210428134252131.jpg",
                                    name= "스타벅스 슬래머",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9564 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[8],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[17]_20210426095334934.jpg",
                                    name= "스팀 우유",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5185 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[8],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2020/09/[9200000001302]_20200921171804529.jpg",
                                    name= "아이스 제주 까망 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5534 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[8],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[18]_20210426095514018.jpg",
                                    name= "우유",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6884 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[8],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2020/09/[9200000001301]_20200921171639781.jpg",
                                    name= "제주 까망 라떼",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7291 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[8],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/10/[9200000004957]_20231005084829402.jpg",
                                    name= "제주팔삭 셔벗",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6490 )),
                            )
                        9 ->
                            mutableListOf<MutableState<Beverage>>(
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[9],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2024/03/[9300000004346]_20240328133443928.jpg",
                                    name= "ABC 클렌즈 190ML",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4709 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[9],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2024/03/[9300000004347]_20240328133658258.jpg",
                                    name= "레몬 진저 클렌즈 190ML",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9009 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[9],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2024/03/[9300000004348]_20240328133830383.jpg",
                                    name= "케일 클렌즈 190ML",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7819 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[9],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[5210008070]_20210426095034991.jpg",
                                    name= "딸기주스 190ML",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 8253 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[9],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[5210008061]_20210426095229362.jpg",
                                    name= "망고주스 190ML",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4996 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[9],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/10/[9300000003773]_20211020094026246.jpg",
                                    name= "스타 루비 자몽 스위트 190ML",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4281 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[9],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/10/[9300000003771]_20211020093812909.jpg",
                                    name= "유기농 오렌지 100% 주스 190ML",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7404 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[9],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/10/[9300000003772]_20211020095105008.jpg",
                                    name= "유기농 오렌지 100% 주스 591ML",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 6544 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[9],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[5210008072]_20210426100712780.jpg",
                                    name= "케일&amp;사과주스 190ML",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 7087 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[9],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/10/[9300000003776]_20211020094321785.jpg",
                                    name= "핑크 용과 레모네이드 190ML",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4979 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[9],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2023/03/[5210008055]_20230331142558998.jpg",
                                    name= "한라봉주스 190ML",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4202 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[9],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9300000002565]_20210426102753285.jpg",
                                    name= "햇사과 주스 190ML",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9827 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[9],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2022/10/[9300000004407]_20221027102828231.jpg",
                                    name= "햇사과 주스 591ML",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 9950 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[9],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/10/[9300000003775]_20211020094208342.jpg",
                                    name= "딸기 가득 요거트 190ML",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 4731 )),
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[9],
                                    imgURL= "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[5210008063]_20210419104847612.jpg",
                                    name= "블루베리 요거트 190ML",
                                    quantity= mutableStateOf<Int>(1),
                                    price= 5871 )),
                            )
                        else ->
                            mutableListOf<MutableState<Beverage>>(
                                mutableStateOf<Beverage>(Coffee(
                                    dataClass= menuEntityDataClass[0],
                                    imgURL= "",
                                    name= "",
                                    quantity= mutableStateOf<Int>(0),
                                    price= 0
                                )
                            )
                        )
                    }
                }
            ) }

            val shoppingCart: MutableState<List<MutableState<Beverage>>> = remember {
                mutableStateOf(listOf())
            }

            Surface(
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                MenuBoard(
                    menuEntityDataClass,
                    menuEntityList,
                    shoppingCart
                )
            }
        }
    }
}