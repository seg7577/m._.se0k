//
//  Varible2.swift
//  test
//
//  Created by m._.se0k on 8/22/24.
//

// 2.변수의 종류는?

import SwiftUI

struct Varible2: View {
    let name: String = "m._.se0k"
    let age: Int = 21 + 1
    let height: Double = 178.3
    let hasJob: Bool = true
    
    var body: some View {
        Text("Hello, \(name) \(age) \(height) \(hasJob.description)")
    }
}

#Preview {
    Varible2()
}
