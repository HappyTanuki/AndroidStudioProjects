package com.my.kiosk

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.my.kiosk.layout.DelivaryOrStoreSelectSplash
import com.my.kiosk.layout.MenuBoard

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val menuEntityDataClass = mutableListOf<MenuEntityDataClass>()
        listOf<String>(
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
        ).forEachIndexed{ i, item ->
            menuEntityDataClass.add(MenuEntityDataClass( item, i ))
        }

        val menuEntityList: MutableState<List<MutableList<MutableState<Beverage>>>> = mutableStateOf(
            List<MutableList<MutableState<Beverage>>>(menuEntityDataClass.size) {
                when(it) {
                    0 ->
                        mutableListOf<MutableState<Beverage>>(
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2024/04/[9200000004544]_20240423124241716.jpg",
                                mutableStateOf<List<String>>(listOf("씨솔트 카라멜 콜드 브루")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4506 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002487]_20210426091745467.jpg",
                                mutableStateOf<List<String>>(listOf("나이트로 바닐라 크림")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7462 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000479]_20210426091843897.jpg",
                                mutableStateOf<List<String>>(listOf("나이트로 콜드 브루")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7017 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002081]_20210415133656839.jpg",
                                mutableStateOf<List<String>>(listOf("돌체 콜드 브루")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5202 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/02/[9200000002407]_20210225095106743.jpg",
                                mutableStateOf<List<String>>(listOf("리저브 나이트로")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9231 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2024/03/[9200000002093]_20240318144604476.jpg",
                                mutableStateOf<List<String>>(listOf("리저브 콜드 브루")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7173 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2022/10/[9200000004312]_20221005145029134.jpg",
                                mutableStateOf<List<String>>(listOf("민트 콜드 브루")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5836 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000487]_20210430112319040.jpg",
                                mutableStateOf<List<String>>(listOf("바닐라 크림 콜드 브루")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8382 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000003661]_20230721170207026.jpg",
                                mutableStateOf<List<String>>(listOf("시그니처 더 블랙 콜드 브루")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7059 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/08/[9200000004750]_20230801101408624.jpg",
                                mutableStateOf<List<String>>(listOf("여수 윤슬 헤이즐넛 콜드브루")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9754 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000003285]_20210416154437069.jpg",
                                mutableStateOf<List<String>>(listOf("오트 콜드 브루")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4717 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2022/03/[9200000002672]_20220311105511600.jpg",
                                mutableStateOf<List<String>>(listOf("제주 비자림 콜드 브루")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4332 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000038]_20210430113202458.jpg",
                                mutableStateOf<List<String>>(listOf("콜드 브루")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5853 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004770]_20230720103902092.jpg",
                                mutableStateOf<List<String>>(listOf("콜드 브루")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8532 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/02/[9200000001636]_20210225093600536.jpg",
                                mutableStateOf<List<String>>(listOf("콜드 브루 몰트")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8695 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/02/[9200000001636]_20210225093600536.jpg",
                                mutableStateOf<List<String>>(listOf("콜드 브루 몰트")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8582 ))),
                        )
                    1 ->
                        mutableListOf<MutableState<Beverage>>(
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[1],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[106509]_20210430111852870.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 커피")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9117 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[1],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[2]_20210430111934117.jpg",
                                mutableStateOf<List<String>>(listOf("오늘의 커피")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4455 ))),
                        )
                    2 ->
                        mutableListOf<MutableState<Beverage>>(
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2024/03/[9200000005181]_20240326103832835.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 플랫 화이트")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7020 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2024/03/[9200000005178]_20240326103727795.jpg",
                                mutableStateOf<List<String>>(listOf("플랫 화이트")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5474 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[30]_20210415144252244.jpg",
                                mutableStateOf<List<String>>(listOf("에스프레소 콘 파나")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7795 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[25]_20210415144211211.jpg",
                                mutableStateOf<List<String>>(listOf("에스프레소 마키아또")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5830 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110563]_20210426095937808.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 카페 아메리카노")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5116 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[94]_20210430103337006.jpg",
                                mutableStateOf<List<String>>(listOf("카페 아메리카노")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8461 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110582]_20210415142706078.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 카라멜 마키아또")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4636 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[126197]_20210415154609863.jpg",
                                mutableStateOf<List<String>>(listOf("카라멜 마키아또")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5896 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110601]_20210415143400773.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 카푸치노")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9911 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[38]_20210415154821846.jpg",
                                mutableStateOf<List<String>>(listOf("카푸치노")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4667 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[9200000004119]_20220412083025862.png",
                                mutableStateOf<List<String>>(listOf("라벤더 카페 브레베")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4268 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/02/[9200000001939]_20210225094313315.jpg",
                                mutableStateOf<List<String>>(listOf("바닐라 빈 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6113 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2024/03/[9200000002095]_20240318144701881.jpg",
                                mutableStateOf<List<String>>(listOf("사케라또 비안코 오버 아이스")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6442 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004732]_20230705095514946.jpg",
                                mutableStateOf<List<String>>(listOf("스타벅스 1호점 바닐라 빈 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8604 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004728]_20230705095319596.jpg",
                                mutableStateOf<List<String>>(listOf("스타벅스 1호점 카페 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7204 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[128692]_20210426091933665.jpg",
                                mutableStateOf<List<String>>(listOf("스타벅스 돌체 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7621 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[9200000004120]_20220412082952150.png",
                                mutableStateOf<List<String>>(listOf("아이스 라벤더 카페 브레베")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7335 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/02/[9200000001941]_20210225094346653.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 바닐라 빈 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5141 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004734]_20230705095557184.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 스타벅스 1호점 바닐라 빈 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4006 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004730]_20230705095423060.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 스타벅스 1호점 카페 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9993 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[128695]_20210426092031969.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 스타벅스 돌체 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5664 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110569]_20210415143035989.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 카페 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8908 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[41]_20210415133833725.jpg",
                                mutableStateOf<List<String>>(listOf("카페 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5687 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110566]_20210415134334280.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 카페 모카")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8792 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110572]_20210415155545375.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 화이트 초콜릿 모카")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4414 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[46]_20210415134438165.jpg",
                                mutableStateOf<List<String>>(listOf("카페 모카")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6585 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2022/10/[9200000004313]_20221005145156959.jpg",
                                mutableStateOf<List<String>>(listOf("클래식 민트 모카")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6149 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[128192]_20210415155639126.jpg",
                                mutableStateOf<List<String>>(listOf("화이트 초콜릿 모카")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9919 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110612]_20210415133425373.jpg",
                                mutableStateOf<List<String>>(listOf("바닐라 스타벅스 더블 샷")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8053 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002950]_20210426150654756.jpg",
                                mutableStateOf<List<String>>(listOf("블론드 바닐라 더블 샷 마키아또")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6699 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/03/[9200000003505]_20210322093241535.jpg",
                                mutableStateOf<List<String>>(listOf("사케라또 아포가토")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9446 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/03/[9200000003506]_20210322093317854.jpg",
                                mutableStateOf<List<String>>(listOf("스파클링 시트러스 에스프레소")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6033 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002953]_20210427132718157.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 블론드 바닐라 더블 샷 마키아또")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4675 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[20]_20210415144112678.jpg",
                                mutableStateOf<List<String>>(listOf("에스프레소")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5099 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110611]_20210415132507539.jpg",
                                mutableStateOf<List<String>>(listOf("커피 스타벅스 더블 샷")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8883 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/02/[9200000001631]_20210225090916684.jpg",
                                mutableStateOf<List<String>>(listOf("클래식 아포가토")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7923 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[2],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110614]_20210415132333109.jpg",
                                mutableStateOf<List<String>>(listOf("헤이즐넛 스타벅스 더블 샷")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9049 ))),
                        )
                    3 ->
                        mutableListOf<MutableState<Beverage>>(
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[3],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[168007]_20210415144337428.jpg",
                                mutableStateOf<List<String>>(listOf("에스프레소 프라푸치노")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8958 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[3],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[168016]_20210415154152122.jpg",
                                mutableStateOf<List<String>>(listOf("자바 칩 프라푸치노")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8478 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[3],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[168010]_20210415154711116.jpg",
                                mutableStateOf<List<String>>(listOf("카라멜 프라푸치노")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7447 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[3],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[168013]_20210415155746379.jpg",
                                mutableStateOf<List<String>>(listOf("화이트 초콜릿 모카 프라푸치노")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5824 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[3],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2020/09/[9200000002088]_20200921171733532.jpg",
                                mutableStateOf<List<String>>(listOf("제주 까망 크림 프라푸치노")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6582 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[3],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002502]_20210426100408048.jpg",
                                mutableStateOf<List<String>>(listOf("제주 말차 크림 프라푸치노")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8331 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[3],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2022/03/[9200000002090]_20220329144732789.jpg",
                                mutableStateOf<List<String>>(listOf("제주 쑥떡 크림 프라푸치노")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9939 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[3],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[168066]_20210415154429750.jpg",
                                mutableStateOf<List<String>>(listOf("초콜릿 크림 칩 프라푸치노")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6139 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[3],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002403]_20210419131548656.jpg",
                                mutableStateOf<List<String>>(listOf("화이트 타이거 프라푸치노")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4481 ))),
                        )
                    4 ->
                        mutableListOf<MutableState<Beverage>>(
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[4],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2024/04/[9200000005171]_20240424090244816.jpg",
                                mutableStateOf<List<String>>(listOf("더블 레몬 블렌디드")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4944 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[4],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2024/04/[9200000005165]_20240423124402730.jpg",
                                mutableStateOf<List<String>>(listOf("스타벅스 클래식 밀크 티 블렌디드")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9504 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[4],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/02/[9200000004512]_20230207150514347.jpg",
                                mutableStateOf<List<String>>(listOf("망고 패션 티 블렌디드")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8695 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[4],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/11/[9200000004716]_20231115093249233.jpg",
                                mutableStateOf<List<String>>(listOf("북한산 레몬 얼 그레이 블렌디드")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5687 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[4],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/12/[9200000004945]_20231205083518102.jpg",
                                mutableStateOf<List<String>>(listOf("스타벅스 클래식 밀크티 블렌디드")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5561 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[4],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/09/[9200000004870]_20230905110300360.jpg",
                                mutableStateOf<List<String>>(listOf("여수 바다 유자 블렌디드")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8991 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[4],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000003276]_20210416154001403.jpg",
                                mutableStateOf<List<String>>(listOf("딸기 딜라이트 요거트 블렌디드")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9652 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[4],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[169001]_20210419130701792.jpg",
                                mutableStateOf<List<String>>(listOf("망고 바나나 블렌디드")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4762 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[4],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/09/[9200000004871]_20230922091835355.jpg",
                                mutableStateOf<List<String>>(listOf("코튼 스카이 요거트 블렌디드")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6495 ))),
                        )
                    5 ->
                        mutableListOf<MutableState<Beverage>>(
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[5],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004753]_20230720103623021.jpg",
                                mutableStateOf<List<String>>(listOf("딸기 아사이 레모네이드 스타벅스 리프레셔")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8558 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[5],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2022/08/[9200000003763]_20220803131322551.jpg",
                                mutableStateOf<List<String>>(listOf("딸기 아사이 레모네이드 스타벅스 리프레셔")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4560 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[5],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004439]_20230710134159744.jpg",
                                mutableStateOf<List<String>>(listOf("망고 용과 레모네이드 스타벅스 리프레셔")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9433 ))),
                        )
                    6 ->
                        mutableListOf<MutableState<Beverage>>(
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[6],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2024/04/[9200000005168]_20240430164715738.jpg",
                                mutableStateOf<List<String>>(listOf("라이트 핑크 자몽 피지오")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8271 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[6],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/10/[9200000004949]_20231005084714271.jpg",
                                mutableStateOf<List<String>>(listOf("레드 애플 피지오")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4809 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[6],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2024/01/[9200000004948]_20240103144748363.jpg",
                                mutableStateOf<List<String>>(listOf("아이스크림 레드 애플 피지오")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7703 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[6],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/09/[9200000004751]_20230907153225204.jpg",
                                mutableStateOf<List<String>>(listOf("여수 바다 자몽 피지오")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5456 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[6],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2022/05/[9200000004121]_20220517102911610.jpg",
                                mutableStateOf<List<String>>(listOf("유자 패션 피지오")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6768 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[6],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2024/01/[9200000004946]_20240103144959834.jpg",
                                mutableStateOf<List<String>>(listOf("제주팔삭 셔벗 피지오")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7151 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[6],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/10/[9200000004947]_20231005084610514.jpg",
                                mutableStateOf<List<String>>(listOf("제주팔삭 피지오")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7084 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[6],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[107051]_20210419112151972.jpg",
                                mutableStateOf<List<String>>(listOf("쿨 라임 피지오")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8082 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[6],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/05/[9200000004567]_20230524144959475.jpg",
                                mutableStateOf<List<String>>(listOf("피치 딸기 피지오")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8218 ))),
                        )
                    7 ->
                        mutableListOf<MutableState<Beverage>>(
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000056]_20210415135215632.jpg",
                                mutableStateOf<List<String>>(listOf("민트 블렌드 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5212 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000059]_20210415141656038.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 민트 블렌드 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6353 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000039]_20210415142055860.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 얼 그레이 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4752 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000229]_20210415142219481.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 유스베리 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5828 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[9200000002959]_20220411155904911.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 유자 민트 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6015 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000019]_20210415142323353.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 잉글리쉬 브렉퍼스트 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6385 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[400400000094]_20210415230316469.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 제주 유기농 녹차로 만든 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9597 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/10/[9200000004944]_20231005084446254.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 제주팔삭 &amp; 자몽 허니 블랙 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6088 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000079]_20210415143641139.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 캐모마일 블렌드 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7431 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000069]_20210415143811231.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 히비스커스 블렌드 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5296 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000036]_20210415143933425.jpg",
                                mutableStateOf<List<String>>(listOf("얼 그레이 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6830 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000226]_20210415144434521.jpg",
                                mutableStateOf<List<String>>(listOf("유스베리 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7947 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[9200000002956]_20220411155551915.jpg",
                                mutableStateOf<List<String>>(listOf("유자 민트 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8381 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000016]_20210415153648533.jpg",
                                mutableStateOf<List<String>>(listOf("잉글리쉬 브렉퍼스트 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8701 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000187]_20210419131229539.jpg",
                                mutableStateOf<List<String>>(listOf("자몽 허니 블랙 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9082 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[400400000091]_20210415132229904.jpg",
                                mutableStateOf<List<String>>(listOf("제주 유기농 녹차로 만든 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4666 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/10/[9200000004943]_20231005084424843.jpg",
                                mutableStateOf<List<String>>(listOf("제주팔삭 &amp; 자몽 허니 블랙 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7506 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000076]_20210415154920731.jpg",
                                mutableStateOf<List<String>>(listOf("캐모마일 블렌드 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7300 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[4004000000066]_20210415155836395.jpg",
                                mutableStateOf<List<String>>(listOf("히비스커스 블렌드 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4110 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/04/[9200000004566]_20230407153247174.jpg",
                                mutableStateOf<List<String>>(listOf("레드 파워 패션 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6518 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/12/[9200000004990]_20231212110704134.jpg",
                                mutableStateOf<List<String>>(listOf("레몬 캐모마일 블렌드 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5102 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/12/[9200000004991]_20231212110749533.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 레몬 캐모마일 블렌드 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4477 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000190]_20210419131723532.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 자몽 허니 블랙 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8586 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/07/[9200000004769]_20230720103743478.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 자몽 허니 블랙 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6110 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/11/[9200000004954]_20231127093740735.jpg",
                                mutableStateOf<List<String>>(listOf("말차 티라미수 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8751 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/12/[9200000004988]_20231212110855121.jpg",
                                mutableStateOf<List<String>>(listOf("스노우 말차 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4682 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/09/[9200000004933]_20230914141717984.jpg",
                                mutableStateOf<List<String>>(listOf("스타벅스 클래식 밀크 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6077 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/10/[9200000004942]_20231005093131816.jpg",
                                mutableStateOf<List<String>>(listOf("스타벅스 클래식 밀크 티 보틀")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4066 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/11/[9200000004955]_20231127093837610.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 말차 티라미수 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4879 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/12/[9200000004989]_20231212110950941.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 스노우 말차 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8669 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/09/[9200000004936]_20230914141811407.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 스타벅스 클래식 밀크 티")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5423 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/01/[9200000004288]_20230118085139616.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 얼 그레이 바닐라 티 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5154 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002499]_20210419130902541.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 제주 말차 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5594 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[135612]_20210415142512793.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 차이 티 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9129 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/01/[9200000004285]_20230118084943128.jpg",
                                mutableStateOf<List<String>>(listOf("얼 그레이 바닐라 티 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7749 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002496]_20210419131039350.jpg",
                                mutableStateOf<List<String>>(listOf("제주 말차 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7263 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[7],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[135608]_20210415154244810.jpg",
                                mutableStateOf<List<String>>(listOf("차이 티 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4569 ))),
                        )
                    8 ->
                        mutableListOf<MutableState<Beverage>>(
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[8],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2024/04/[9200000004939]_20240430143115844.jpg",
                                mutableStateOf<List<String>>(listOf("스타벅스 딸기 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9395 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[8],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/12/[9200000004950]_20231204090636952.jpg",
                                mutableStateOf<List<String>>(listOf("딸기 콜드폼 초콜릿")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7897 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[8],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[72]_20210415140949967.jpg",
                                mutableStateOf<List<String>>(listOf("시그니처 핫 초콜릿")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6860 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[8],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110621]_20210415140901611.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 시그니처 초콜릿")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4469 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[8],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/11/[9200000004953]_20231127094019543.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 티라미수 초콜릿")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8420 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[8],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/11/[9200000004952]_20231127093937845.jpg",
                                mutableStateOf<List<String>>(listOf("티라미수 초콜릿")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8743 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[8],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000003658]_20210422080248176.jpg",
                                mutableStateOf<List<String>>(listOf("플러피 판다 아이스 초콜릿")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8900 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[8],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002594]_20210422080327783.jpg",
                                mutableStateOf<List<String>>(listOf("플러피 판다 핫 초콜릿")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4547 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[8],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/11/[9200000004951]_20231102101647442.jpg",
                                mutableStateOf<List<String>>(listOf("딸기 콜드폼 딸기 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4417 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[8],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000003659]_20210428134252131.jpg",
                                mutableStateOf<List<String>>(listOf("스타벅스 슬래머")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9564 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[8],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[17]_20210426095334934.jpg",
                                mutableStateOf<List<String>>(listOf("스팀 우유")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5185 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[8],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2020/09/[9200000001302]_20200921171804529.jpg",
                                mutableStateOf<List<String>>(listOf("아이스 제주 까망 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5534 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[8],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[18]_20210426095514018.jpg",
                                mutableStateOf<List<String>>(listOf("우유")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6884 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[8],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2020/09/[9200000001301]_20200921171639781.jpg",
                                mutableStateOf<List<String>>(listOf("제주 까망 라떼")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7291 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[8],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/10/[9200000004957]_20231005084829402.jpg",
                                mutableStateOf<List<String>>(listOf("제주팔삭 셔벗")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6490 ))),
                        )
                    9 ->
                        mutableListOf<MutableState<Beverage>>(
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[9],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2024/03/[9300000004346]_20240328133443928.jpg",
                                mutableStateOf<List<String>>(listOf("ABC 클렌즈 190ML")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4709 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[9],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2024/03/[9300000004347]_20240328133658258.jpg",
                                mutableStateOf<List<String>>(listOf("레몬 진저 클렌즈 190ML")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9009 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[9],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2024/03/[9300000004348]_20240328133830383.jpg",
                                mutableStateOf<List<String>>(listOf("케일 클렌즈 190ML")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7819 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[9],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[5210008070]_20210426095034991.jpg",
                                mutableStateOf<List<String>>(listOf("딸기주스 190ML")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 8253 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[9],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[5210008061]_20210426095229362.jpg",
                                mutableStateOf<List<String>>(listOf("망고주스 190ML")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4996 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[9],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/10/[9300000003773]_20211020094026246.jpg",
                                mutableStateOf<List<String>>(listOf("스타 루비 자몽 스위트 190ML")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4281 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[9],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/10/[9300000003771]_20211020093812909.jpg",
                                mutableStateOf<List<String>>(listOf("유기농 오렌지 100% 주스 190ML")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7404 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[9],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/10/[9300000003772]_20211020095105008.jpg",
                                mutableStateOf<List<String>>(listOf("유기농 오렌지 100% 주스 591ML")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 6544 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[9],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[5210008072]_20210426100712780.jpg",
                                mutableStateOf<List<String>>(listOf("케일&amp;사과주스 190ML")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 7087 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[9],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/10/[9300000003776]_20211020094321785.jpg",
                                mutableStateOf<List<String>>(listOf("핑크 용과 레모네이드 190ML")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4979 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[9],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2023/03/[5210008055]_20230331142558998.jpg",
                                mutableStateOf<List<String>>(listOf("한라봉주스 190ML")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4202 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[9],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9300000002565]_20210426102753285.jpg",
                                mutableStateOf<List<String>>(listOf("햇사과 주스 190ML")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9827 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[9],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2022/10/[9300000004407]_20221027102828231.jpg",
                                mutableStateOf<List<String>>(listOf("햇사과 주스 591ML")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 9950 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[9],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/10/[9300000003775]_20211020094208342.jpg",
                                mutableStateOf<List<String>>(listOf("딸기 가득 요거트 190ML")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 4731 ))),
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[9],
                                "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[5210008063]_20210419104847612.jpg",
                                mutableStateOf<List<String>>(listOf("블루베리 요거트 190ML")),
                                mutableStateOf<Int>(1),
                                mutableStateOf<Int>( 5871 ))),
                        )
                    else ->
                        mutableListOf<MutableState<Beverage>>(
                            mutableStateOf<Beverage>( Coffee(
                                menuEntityDataClass[0],
                                "",
                                mutableStateOf<List<String>>(listOf("")),
                                mutableStateOf<Int>(0),
                                mutableStateOf<Int>(0)
                            )
                            )
                        )
                }
            }
        )

        val transactionCompleted = mutableStateOf<Boolean>(false)
        val showOrdertypeSelectionScreen = mutableStateOf<Boolean>(true)
        var firstLaunched = true

        setContent {
            var shoppingCart: MutableList<Beverage> = remember { mutableListOf() }

            LaunchedEffect(transactionCompleted.value) {
                if (!firstLaunched) {
                    Toast.makeText(
                        applicationContext,
                        "결제가 완료되었습니다. 카운터에서 음료를 받아주세요",
                        Toast.LENGTH_SHORT
                    ).show()
                    shoppingCart.clear()
                    showOrdertypeSelectionScreen.value = true
                }
                else {
                    firstLaunched = false
                }
            }

            if (showOrdertypeSelectionScreen.value)
                DelivaryOrStoreSelectSplash(showOrdertypeSelectionScreen)

            Surface(
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                MenuBoard(
                    menuEntityDataClass,
                    menuEntityList,
                    shoppingCart,
                    transactionCompleted
                )
            }
        }
    }
}