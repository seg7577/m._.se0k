//
//  MyEnum.swift
//  Swift_ grammar
//
//  Created by m._.se0k on 8/23/24.
//

import SwiftUI

struct MyEnum: View {
    
    @State var menu: Menu = .pork
    
    enum Menu{
        case beaf, pork, chicken
    }
    
    var body: some View {
        if menu == .beaf{
            Text("오늘 메뉴는 소고기")
        }
        else if menu == .pork{
            Text("오늘 메뉴는 돼지고기")
        }
        else if menu == .chicken{
            Text("오늘 메뉴는 닭고기")
        }
        else{
            Text("이걸 먹을 수 있나?")
        }
    }
}

#Preview {
    MyEnum()
}
