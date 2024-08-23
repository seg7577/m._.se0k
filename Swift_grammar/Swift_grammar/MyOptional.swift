//
//  MyOptional.swift
//  Swift_ grammar
//
//  Created by m._.se0k on 8/23/24.
//

import SwiftUI

struct MyOptional: View {
    
    let name: String
    let age: Int?
    
    var body: some View {
        VStack{
            Text(name)
            //Text(age?.description ?? "100")
            if let age = age{   //만약 age가 Int라면 값을 let age에 저장해줘.. 라는 뜻임
                Text(age.description)
            }
        }
    }
}

#Preview {
    MyOptional(name: "m._.se0k", age: 22)
    //MyOptional(name: "m._.se0k", age: nil)
    //위의 코드에서 age가 Optional이기 때문에 값을 넘겨줘야 한다.
    //Optional : 만약 반환 받은 값이 올바르지 않은 경우 nil(NULL)을 반환한다. -> 뜻은 있을 수도, 없을 수도..
    //아무것도 없다는 오류처리에 사용될 수 있을 것으로 보임
}
