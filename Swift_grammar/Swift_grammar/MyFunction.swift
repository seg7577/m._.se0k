//
//  MyFunction.swift
//  Swift_ grammar
//
//  Created by m._.se0k on 8/23/24.
//

import SwiftUI

struct MyFunction: View {
    
    @State var myMind: String = "nothing"
    @State var isChangedMind: Bool = false
    
    var body: some View {
        VStack{
            Text(myMind)
            Button{
                isChangedMind.toggle()
                myMind = getMind(with: isChangedMind)
            } label:{
                Text("Change my Mind!")
            }
        }
    }
    
    func getMind(with isChangedMind: Bool)->String{
        if isChangedMind{
            return "always open"
        } else{
            return "but closed"
        }
    }
}

#Preview {
    MyFunction()
}
