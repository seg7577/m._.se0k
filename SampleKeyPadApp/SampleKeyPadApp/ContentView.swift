//
//  ContentView.swift
//  SampleKeyPadApp
//
//  Created by m._.se0k on 9/4/24.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack{
            
            ForEach(dialDummy, id: \.self) {
                item in 
                HStack{
                    DialButton(dialNumber: Dial(mainNumber: item.mainNumber, subNumber: item.subNumber))
                }
            }
            
//            HStack{
//                DialButton(dialNumber: Dial(mainNumber: "1", subNumber: ["", "", ""]))
//                DialButton(dialNumber: Dial(mainNumber: "2", subNumber: ["A", "B", "C"]))
//                DialButton(dialNumber: Dial(mainNumber: "3", subNumber: ["D", "E", "F"]))
//            }
//            HStack{
//                DialButton(dialNumber: Dial(mainNumber: "4", subNumber: ["G", "H", "I"]))
//                DialButton(dialNumber: Dial(mainNumber: "5", subNumber: ["J", "K", "L"]))
//                DialButton(dialNumber: Dial(mainNumber: "6", subNumber: ["M", "N", "O"]))
//            }
//            HStack{
//                DialButton(dialNumber: Dial(mainNumber: "7", subNumber: ["P", "Q", "R", "S"]))
//                DialButton(dialNumber: Dial(mainNumber: "8", subNumber: ["T", "U", "V"]))
//                DialButton(dialNumber: Dial(mainNumber: "9", subNumber: ["W", "X", "Y", "Z"]))
//            }
        }
    }
}

#Preview {
    ContentView()
}
