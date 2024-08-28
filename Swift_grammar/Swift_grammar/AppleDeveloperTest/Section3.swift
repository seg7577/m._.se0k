//
//  Section3.swift
//  Swift_grammar
//
//  Created by m._.se0k on 8/27/24.
//

import SwiftUI



struct Section3: View {
    var body: some View {
       
        VStack{
            Image(systemName: "globe").imageScale(.large).foregroundColor(.green)
                .background(Color.black, in: Rectangle())
            Text("Hello, world!")
                .padding()
                .background(Color.red, in: Ellipse())

            Text("Knock, knock!")
                .padding()
                .background(Color.yellow, in: RoundedRectangle(cornerRadius:20))
            Text(" Who's there? ")
                .padding()
                .background(Color.blue, in: Circle())
        
        }
        .padding()
    }
}
    
#Preview {
    Section3()
}
