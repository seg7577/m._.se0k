//
//  Variable.swift
//  test
//
//  Created by m._.se0k on 8/22/24.
//


// 1. 변수 왜 그리고 어떻게 쓰는 지
import SwiftUI

struct Variable: View {
    let name = "Hi m._se0k"
    //변수 키워드 : let, var 이 두 가지가 있음
    var body: some View {
        VStack{
            //Vertical Stack의 줄임말
            Text("name")
            Text("name")
            Text("name")

        }
    }
}

#Preview {
    Variable()
}
