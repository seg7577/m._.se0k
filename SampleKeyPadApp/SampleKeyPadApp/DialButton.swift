//
//  DialButton.swift
//  SampleKeyPadApp
//
//  Created by m._.se0k on 9/4/24.
//

import SwiftUI


struct DialButton: View {
    
    let dialNumber: Dial
    
    var body: some View {
        Button{
            
        } label: {
            VStack(spacing: 0) {
                Text(dialNumber.mainNumber)
                    .font(.system(size: 30))
                    .padding(.vertical, -5)
                HStack(spacing: 0){
                    ForEach(dialNumber.subNumber, id: \.self){
                        item in Text(item)
                            .font(.system(size: 10))
                    }
                }
            }
            .foregroundColor(.white)
            .frame(width: 65, height: 65)
            .background(.gray)
            .clipShape(/*@START_MENU_TOKEN@*/Circle()/*@END_MENU_TOKEN@*/)
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
