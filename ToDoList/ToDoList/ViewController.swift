//
//  ViewController.swift
//  ToDoList
//
//  Created by m._.se0k on 8/22/24.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var tableView: UITableView!
    @IBOutlet var deitButton: UIBarButtonItem!
    
    var doneButton: UIBarButtonItem?
    var tasks = [Task]()
    {
        didSet{
            //프로퍼티 옵저버, tasks 배열에 할일이 추가될 때마다 유저 디포틀에 할일이 저장됨
            self.saveTasks()
        }
    }//Task 배열 생성
    
    @IBAction func tapeditButton(_sender: UIBarButtonItem)
    {
        guard !self.tasks.isEmpty else(return)
            self.navigationItem.leftBarButtonItem = self.doneButton
            self.tableView.setEditing(true, animated: true)
    }
    /*
     우선 viewController class에 tableView라는 이름의 IBOutlet 변수를 생성해주고, editButton IBOulet 변수도 생성해 준다. editBitton은 UIBarButtonItem 형태로 형성해주었다.
     (doneButtonn, tasks 등은 추후 또 해당 기능을 추가할 때 리뷰하도록 함. 우선ㄴ 아웃렛 변수만 집중)
     
     그리고 edit과 add 버튼에 대한 액션함수도 추가해주겠다.(@IBAction함수)
     *

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
     */

}

