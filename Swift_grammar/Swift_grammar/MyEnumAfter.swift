////
////  MyEnumAfter.swift
////  Swift_grammar
////
////  Created by m._.se0k on 9/4/24.
////
//
//import SwiftUI
//
//
//enum Drink {
//    
//    case coffee(caffeine: Int, hasSyrup: Bool, hasMilk: Bool)
//    
//    
//    case juice
//    case soft(color: Color)
//}
//
//struct MyEnumAfter: View {
//    let myDrinks: Drink = .coffee(caffeine: 9, hasSyrup: false, hasMilk: true)
//    let myDrinks2: Drink = .soft(color: .red)
//    
//    var body: some View {
//        switch myDrinks {
//        case .coffee(caffeine: let caffine, hasSyrup: let hasSyrup, hasMilk: let hasMilk):
//            if hasMilk{
//                Text("Latte")
//            } else {
//                Text("Americano")
//            }
//            
//        case .juice:
//            Text("")
//            
//        case .soft(color: let color):
//            switch drinkColor{
//            case .red:
//                Text("토마토주스!")
//            default:
//                Text("콜라!")
//            }
//            
//        default:
//            Text("asdasd")
//        }
//    }
//    
//}
//
//#Preview {
//    MyEnumAfter()
//}
