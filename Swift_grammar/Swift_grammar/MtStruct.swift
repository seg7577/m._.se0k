//
//  MtStruct.swift
//  Swift_grammar
//
//  Created by m._.se0k on 8/27/24.
//

import SwiftUI

struct UserInfo{
    let name: String
    let age: Int?
    let email: String?
    let job: String?
    let hasPet: Bool?
    
    func sayMyName(with name: String){
        print("play Function!", name)
    }
    
}

struct MtStruct: View {
    
    let userInfo: UserInfo
    
    var body: some View {
        
        
        VStack{
            Text("name : \(userInfo.name)")
            Text("age :\(userInfo.age?.description ?? "100")")
            Text("email : \(userInfo.email?.description ?? "100")")
            Text("job : \(userInfo.job?.description ?? "100")")
            Text("hasPet : \(userInfo.hasPet?.description ?? "100")")
            //앞서 배운 옵셔널 바인딩을 통해 값을 안전하게 추출한다. 이후 옵셔널 체이닝(Optional Binding): 옵셔널 값에 접근할 때 '?'를 사용하여 값이 존재하면 이를 사용하고, 값이 존재하지 않으면 'nil'(NULL과 같은 개념)을 반환하는 방법이다.
            
            Button {
                userInfo.sayMyName(with: userInfo.name)
                //with은 메서드를 정의할 때 사용하는 매개변수(Parameter)이다. 이는 매개변수가 사용되는 맥락을 설명해주는 역할과 의미를 부여해준다.
            } label: {
                Text("Button")
            }
        }
    }
    
}

struct MyStruct_Previews: PreviewProvider{
    static var previews: some View{
        let min = UserInfo(name: "m._.se0k",
                           age: 22,
                           email: "hi@naver.com",
                           job: "student",
                           hasPet: true)
        
        MtStruct(userInfo: min)
    }
}
//
//#Preview {
//}
