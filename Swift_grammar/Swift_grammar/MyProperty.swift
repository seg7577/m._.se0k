//
//  MyProperty.swift
//  Swift_grammar
//
//  Created by m._.se0k on 9/3/24.
//

import SwiftUI

struct MyProperty: View {
    
    @State var koreaMoney: Int = 1000
    var japenesMoney: Int {
        get{
            return koreaMoney / 10
        }
    }
    //프로퍼티 -> 저장 프로퍼티 <- 변수
    //       -> 연산 프로퍼티
    var body: some View {
        VStack{
            Text("\(koreaMoney.description)원 있습니다.")
            Text("\(japenesMoney.description)엔 있습니다.")
            Button{
                koreaMoney = 200
            } label: {
                Text("Hitto")
            }
        }
    }
}

#Preview {
    MyProperty()
}
