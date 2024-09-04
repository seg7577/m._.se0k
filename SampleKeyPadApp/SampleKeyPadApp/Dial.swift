//
//  Dial.swift
//  SampleKeyPadApp
//
//  Created by m._.se0k on 9/5/24.
//

import Foundation

struct Dial: Identifiable, Hashable{
    var id = UUID()
    var mainNumber: String
    var subNumber: [String]
    
   
}
var dialDummy = [Dial(mainNumber: "1", subNumber: ["","", ""]),
                 Dial(mainNumber: "2", subNumber: ["A", "B", "C"]),
                 Dial(mainNumber: "3", subNumber: ["D", "E", "F"]),
                 Dial(mainNumber: "4", subNumber: ["G", "H", "I"]),
                 Dial(mainNumber: "5", subNumber: ["J", "K", "L"]),
                 Dial(mainNumber: "6", subNumber: ["M", "N", "O"]),
                 Dial(mainNumber: "7", subNumber: ["P", "Q", "R", "S"]),
                 Dial(mainNumber: "8", subNumber: ["T", "U", "V"]),
                 Dial(mainNumber: "9", subNumber: ["W", "X", "Y", "Z"]),
                 Dial(mainNumber: "0", subNumber: ["+"])

]

