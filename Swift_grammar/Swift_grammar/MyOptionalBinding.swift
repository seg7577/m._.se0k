//
//  MyOptionalBinding.swift
//  Swift_grammar
//
//  Created by m._.se0k on 9/2/24.
//

import SwiftUI

struct MyOptionalBinding: View {
    
    var nickName: String? = nil
    //옵셔널 : 값이 있을 수도, 없을 수도 있는 것, 옵셔널 기호를 붙이면 해당 자료형과 nil 값이 들어갈 수 있게 됨
    
    var body: some View {
        Text(nickName ?? "default")
        //1. nickName'!' : 옵셔널이 붙어 있는 경우 '!'을 사용하여 값을 강제로 가져올 수 있음. 단, 만약에 nickName의 값이 nil인 경우 '!'을 사용하면 앱이 꺼져버림.(상당히 위험함) -> 강의에서는 비추함
        
        //2. "??" : 옵셔널이 붙어 있는 경우 "??"을 사용하면 앞에 있는 변수가 nil 값을 가지고 있는 경우 "default"라는 문자열로 대체한다는 의미를 가짐
        
//        3. if let nickName = nickName{
//            Text(nickName)
//        }   else {
//                Text("nickName")
//        }
        
    }
}

#Preview {
    MyOptionalBinding()
}
