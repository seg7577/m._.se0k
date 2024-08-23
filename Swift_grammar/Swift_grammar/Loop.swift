//
//  Loop.swift
//  Swift_ grammar
//
//  Created by m._.se0k on 8/23/24.
//

import SwiftUI

struct Loop: View {
    
    let farmAnimals = ["🐶", "🐈", "🐮", "🐳"]
    var body: some View {
        VStack{
            ForEach(farmAnimals,
                    id: \.self){ animal in
                Text(animal)
            }
        }
    }
}

#Preview {
    Loop()
}
